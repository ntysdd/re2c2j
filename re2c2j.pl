use v5.12;
use strict;
use warnings;

use IO::Handle qw();

# the input filename
sub get_input_filename {
    local $_;
    my $filename;
    for ( my $i = 0 ; $i < @ARGV ; $i++ ) {
        my $f = $ARGV[$i];
        if ( $f eq '--' ) {
            $filename = $ARGV[ $i + 1 ];
            last;
        }
        if ( defined $f and $f !~ /\A-/ ) {
            $filename = $f;
            last;
        }
    }
    if ( not defined $filename ) {
        die "need filename\n";
    }
    return $filename;
}

my $filename = get_input_filename();

# fork, setup pipe
sub fork_pipe($) {
    local $_;
    my ($io) = @_;
    pipe $io, my $to_write or die;
    my $pid = fork;
    die "can't fork: $!\n" unless defined $pid;
    if ($pid) {
        close $to_write;
        return $pid;
    }
    else {
        close $io;
        open STDOUT, '>&=', fileno($to_write) or die;
        return 0;
    }
}

my $to_read = IO::Handle->new();
my $pid     = fork_pipe($to_read);
if ( $pid == 0 ) {
    my @args = ( 're2c', '--nested-ifs', '--utf-16', '--', $filename );
    { exec { $args[0] } @args; }

    # somehow exec failed
    close STDOUT;
    die;
}

# collect output from re2c
my @re2c_output;
while (<$to_read>) {
    chomp;

    push @re2c_output, $_;
}

# wait child
wait;

if ( $? != 0 ) {

    # re2c error
    die "re2c error. error code = $?\n";
}

use constant EMPTY_LINE                   => 'EMPTY_LINE';
use constant COMMENT                      => 'COMMENT';
use constant LINE_COMMENT                 => 'LINE_COMMENT';
use constant LEFT_BRACE                   => 'LEFT_BRACE';
use constant RIGHT_BRACE                  => 'RIGHT_BRACE';
use constant DEFINE_YYCH                  => 'DEFINE_YYCH';
use constant ASSIGN_YYCH_YYCURSOR         => 'ASSIGN_YYCH_YYCURSOR';
use constant ASSIGN_YYCH_INC_YYCURSOR     => 'ASSIGN_YYCH_INC_YYCURSOR';
use constant CMP_YYLIMIT_LESS_EQ_YYCURSOR => 'CMP_YYLIMIT_LESS_EQ_YYCURSOR';
use constant ELSE_WITH_BRACES             => 'ELSE_WITH_BRACES';
use constant INC_YYCURSOR                 => 'INC_YYCURSOR';
use constant ASSIGN_YYMARKER_INC_YYCURSOR => 'ASSIGN_YYMARKER_INC_YYCURSOR';
use constant ASSIGN_YYMARKER_YYCURSOR     => 'ASSIGN_YYMARKER_YYCURSOR';
use constant ASSIGN_YYCURSOR_YYMARKER     => 'ASSIGN_YYCURSOR_YYMARKER';

use constant EQ => 'EQ';
use constant NE => 'NE';
use constant GE => 'GE';
use constant LE => 'LE';

my $C_SPACE = qr/(?: |\t|\v|\f)+/;
my $C_CHAR_LIT =
  qr/ ' (?: \\\\ | \\' | [\x20-\x26] | [\x28-\x5b] | [\x5d-\x7e] ) ' /x;

my $is_in_user_code = 0;

package UserCode;
use overload '""' => '_stringify';

sub new {
    my ( $name, $usercode ) = @_;
    my $self = { _usercode => $usercode };
    bless $self, $name;
    $self;
}

sub usercode {
    my ($self) = @_;
    $self->{_usercode};
}

sub _stringify {
    my ($self) = @_;
    my $usercode = $self->usercode;
    "UserCode($usercode)";
}

package YyLabel;
use overload '""' => '_stringify';

sub new {
    my ( $name, $label ) = @_;
    my $self = { _label => $label };
    bless $self, $name;
    $self;
}

sub label {
    my ($self) = @_;
    $self->{_label};
}

sub _stringify {
    my ($self) = @_;
    my $label = $self->label;
    "YyLabel($label)";
}

package GotoLabel;
use overload '""' => '_stringify';

sub new {
    my ( $name, $label ) = @_;
    my $self = { _label => $label };
    bless $self, $name;
    $self;
}

sub label {
    my ($self) = @_;
    $self->{_label};
}

sub _stringify {
    my ($self) = @_;
    my $label = $self->label;
    "GotoLabel($label)";
}

package CmpYychIf;
use overload '""' => '_stringify';

sub new {
    my ( $name, $op, $rhs ) = @_;
    die unless $op =~ /\A (?: EQ | NE | GE | LE ) \z/x;
    die unless $rhs =~ /\A (?: $C_CHAR_LIT | 0x[0-9a-f]{2} ) \z/x;
    my $self = { _op => $op, _rhs => $rhs };
    bless $self, $name;
    $self;
}

sub op {
    my ($self) = @_;
    $self->{_op};
}

sub rhs {
    my ($self) = @_;
    $self->{_rhs};
}

sub _stringify {
    my ($self) = @_;
    my $op     = $self->op;
    my $rhs    = $self->rhs;
    "YyLabel(op => $op, rhs => $rhs)";
}

package CmpYychIfGoto;
use overload '""' => '_stringify';

sub new {
    my ( $name, $op, $rhs, $label ) = @_;
    die unless $op =~ /\A (?: EQ | NE | GE | LE ) \z/x;
    die unless $rhs =~ /\A (?: $C_CHAR_LIT | 0x[0-9a-f]{2} ) \z/x;
    die unless $label =~ /\A yy (?: eof| [0-9]+_? ) \z/x;

    my $self = { _op => $op, _rhs => $rhs, _label => $label };
    bless $self, $name;
    $self;
}

sub op {
    my ($self) = @_;
    $self->{_op};
}

sub rhs {
    my ($self) = @_;
    $self->{_rhs};
}

sub label {
    my ($self) = @_;
    $self->{_label};
}

sub _stringify {
    my ($self) = @_;
    my $op     = $self->op;
    my $rhs    = $self->rhs;
    my $label  = $self->label;
    "YyLabel(op => $op, rhs => $rhs, label => $label)";
}

package CmpYyfill0Goto;
use overload '""' => '_stringify';

sub new {
    my ( $name, $label ) = @_;
    die unless $label =~ /\A yy (?: eof| [0-9]+_? ) \z/x;

    my $self = { _label => $label };
    bless $self, $name;
    $self;
}

sub label {
    my ($self) = @_;
    $self->{_label};
}

sub _stringify {
    my ($self) = @_;
    my $label = $self->label;
    "CmpYyfill0Goto(label => $label)";
}

package main;

my %label_map;
my $label_count = 0;

sub get_line_type($) {
    local $_ = $_[0];
    if (m{\A#line [0-9]+ (.*)$}) {
        if ( $1 eq q{"<stdout>"} ) {
            $is_in_user_code = 0;
        }
        else {
            $is_in_user_code = 1;
        }
        return LINE_COMMENT;
    }

    if ($is_in_user_code) {
        return UserCode->new($_);
    }

    if (m{\A$C_SPACE*\z}) {
        return EMPTY_LINE;
    }

    if (m{\A$C_SPACE*\Q/*\E(?:\s|\S)*\Q*/\E\z}) {
        my $comment_end_pos = index $_, '*/';
        if ( $comment_end_pos != length($_) - 2 ) {
            goto error;
        }
        return COMMENT;
    }

    if (m<\A$C_SPACE*\Q{\E$C_SPACE*\z>) {
        return LEFT_BRACE;
    }

    if (m<\A$C_SPACE*\Q}\E$C_SPACE*\z>) {
        return RIGHT_BRACE;
    }

    if (m{\A$C_SPACE*YYCTYPE yych;$C_SPACE*\z}) {
        return DEFINE_YYCH;
    }

    if (m{\Ayy(?:eof|[0-9]+_?):\z}) {
        my $label = $_;
        $label =~ s/:$//;
        if ( not exists $label_map{$label} ) {
            $label_count++;
            my $nth = $label_count;
            $label_map{$label} = $nth;
        }
        return YyLabel->new($label);
    }

    if (m{\A$C_SPACE*\Qyych = *YYCURSOR;\E$C_SPACE*\z}) {
        return ASSIGN_YYCH_YYCURSOR;
    }
    if (m{\A$C_SPACE*\Qyych = *++YYCURSOR;\E$C_SPACE*\z}) {
        return ASSIGN_YYCH_INC_YYCURSOR;
    }

    if (m{\A$C_SPACE*\QYYMARKER = YYCURSOR;\E$C_SPACE*\z}) {
        return ASSIGN_YYMARKER_YYCURSOR;
    }

    if (m{\A$C_SPACE*\QYYMARKER = ++YYCURSOR;\E$C_SPACE*\z}) {
        return ASSIGN_YYMARKER_INC_YYCURSOR;
    }

    if (m{\A$C_SPACE*\QYYCURSOR = YYMARKER;\E$C_SPACE*\z}) {
        return ASSIGN_YYCURSOR_YYMARKER;
    }

    if (m[\A$C_SPACE*\Qif (yych <= \E(0x[0-9a-f]{2}|$C_CHAR_LIT)\Q) {\E\z]) {
        return CmpYychIf->new( LE, $1 );
    }

    if (m[\A$C_SPACE*\Qif (yych >= \E(0x[0-9a-f]{2}|$C_CHAR_LIT)\Q) {\E\z]) {
        return CmpYychIf->new( GE, $1 );
    }

    if (
        m[\A$C_SPACE*
	\Qif (yych == \E
	(0x[0-9a-f]{2}|$C_CHAR_LIT)
	\Q) goto \E
	(yyeof|yy[0-9]+_?);\z]x
      )
    {
        return CmpYychIfGoto->new( EQ, $1, $2 );
    }

    if (
        m[\A$C_SPACE*
	\Qif (yych != \E
	(0x[0-9a-f]{2}|$C_CHAR_LIT)
	\Q) goto \E
	(yyeof|yy[0-9]+_?);\z]x
      )
    {
        return CmpYychIfGoto->new( NE, $1, $2 );
    }

    if (
        m[\A$C_SPACE*
	\Qif (yych >= \E
	(0x[0-9a-f]{2}|$C_CHAR_LIT)
	\Q) goto \E
	(yyeof|yy[0-9]+_?);\z]x
      )
    {
        return CmpYychIfGoto->new( GE, $1, $2 );
    }

    if (m[\A$C_SPACE*\Qif (YYLIMIT <= YYCURSOR) {\E\z]) {
        return CMP_YYLIMIT_LESS_EQ_YYCURSOR;
    }

    if (m[\A$C_SPACE*\Q} else {\E$C_SPACE*\z]) {
        return ELSE_WITH_BRACES;
    }

    if (
        m[\A$C_SPACE*
	\Qif (YYFILL\E $C_SPACE*
	\Q() == 0) goto \E
	(yyeof|yy[0-9]+_?);\z]x
      )
    {
        return CmpYyfill0Goto->new($1);
    }

    if (m{\A$C_SPACE*goto (yyeof|yy[0-9]+_?);\z}) {
        return GotoLabel->new($1);
    }

    if (m{\A$C_SPACE*\Q++YYCURSOR;\E\z}) {
        return INC_YYCURSOR;
    }
  error:
    die "failed to parse re2c output `$_'";
}

my @processed_line;

sub pre_processing_re2c_output {
    local $_;
    for my $line (@_) {
        my $type = get_line_type($line);

        push @processed_line, $type;
    }
}

pre_processing_re2c_output(@re2c_output);

sub match_str($$) {
    my ( $obj, $str ) = @_;
    return ( ref $obj eq '' ) && ( $obj eq $str );
}

sub translate_op($) {
    my ($op) = @_;
    if ( $op eq EQ ) {
        return '==';
    }
    if ( $op eq NE ) {
        return '!=';
    }
    if ( $op eq GE ) {
        return '>=';
    }
    if ( $op eq LE ) {
        return '<=';
    }
}

for (@processed_line) {
    if ( ref $_ eq 'UserCode' ) {
        say $_->usercode();
        next;
    }
    if ( match_str( $_, LEFT_BRACE ) ) {
        say '{';
        next;
    }
    if ( match_str( $_, RIGHT_BRACE ) ) {
        say '}';
        next;
    }
    if ( match_str( $_, ELSE_WITH_BRACES ) ) {
        say '} else {';
        next;
    }
    if ( match_str( $_, DEFINE_YYCH ) ) {
        say 'char yych;
	int SWITCH_STATE = 0;
	while (true){
	switch (SWITCH_STATE) {
	case 0:';
        next;
    }
    if ( ref $_ eq 'YyLabel' ) {
        my $label_number = $label_map{ $_->label };
        say "case $label_number:";
        next;
    }
    if ( match_str( $_, ASSIGN_YYCH_YYCURSOR ) ) {
        say 'yych = INPUT_BUF[YYCURSOR];';
        next;
    }
    if ( match_str( $_, ASSIGN_YYCH_INC_YYCURSOR ) ) {
        say 'yych = INPUT_BUF[++YYCURSOR];';
        next;
    }
    if ( match_str( $_, ASSIGN_YYCURSOR_YYMARKER ) ) {
        say 'YYCURSOR = YYMARKER;';
        next;
    }
    if ( match_str( $_, ASSIGN_YYMARKER_YYCURSOR ) ) {
        say 'YYMARKER = YYCURSOR;';
        next;
    }
    if ( match_str( $_, ASSIGN_YYMARKER_INC_YYCURSOR ) ) {
        say 'YYMARKER = ++YYCURSOR;';
        next;
    }
    if ( match_str( $_, INC_YYCURSOR ) ) {
        say '++YYCURSOR;';
        next;
    }
    if ( ref $_ eq 'CmpYychIf' ) {
        my $op  = translate_op( $_->op );
        my $rhs = $_->rhs;
        say "if (yych $op $rhs) {";
        next;
    }
    if ( ref $_ eq 'CmpYychIfGoto' ) {
        my $op    = translate_op( $_->op );
        my $rhs   = $_->rhs;
        my $label = $_->label;
        say "if (yych $op $rhs) {
        SWITCH_STATE = @{[$label_map{$label}]};
        continue;
        }";
        next;
    }
    if ( ref $_ eq 'GotoLabel' ) {
        my $label = $_->label;
        say "{
        SWITCH_STATE = @{[$label_map{$label}]};
        continue;
        }";
        next;
    }
    if ( match_str( $_, CMP_YYLIMIT_LESS_EQ_YYCURSOR ) ) {
        say "if (YYLIMIT <= YYCURSOR) {";
        next;
    }
    if ( ref $_ eq 'CmpYyfill0Goto' ) {
        my $label = $_->label;
        say "if (YYFILL () == 0) {
        SWITCH_STATE = @{[$label_map{$label}]};
        continue;
	}";
        next;
    }
}
say '}}';
