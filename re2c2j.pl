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
    my @args = ( 're2c', '--nested-ifs', '--', $filename );
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

#debug
print "$_\n" for @re2c_output;

use constant EMPTY_LINE                   => 'EMPTY_LINE';
use constant COMMENT                      => 'COMMENT';
use constant LINE_COMMENT                 => 'LINE_COMMENT';
use constant LEFT_BRACE                   => 'LEFT_BRACE';
use constant RIGHT_BRACE                  => 'RIGHT_BRACE';
use constant DEFINE_YYCH                  => 'DEFINE_YYCH';
use constant DEFINE_YYLABEL               => 'DEFINE_YYLABEL';
use constant ASSIGN_YYCH_YYCURSOR         => 'ASSIGN_YYCH_YYCURSOR';
use constant CMP_YYCH_LESS_EQ_CONSTANT    => 'CMP_YYCH_LESS_EQ_CONSTANT';
use constant CMP_YYCH_EQ_CONSTANT_GOTO    => 'CMP_YYCH_EQ_CONSTANT_GOTO';
use constant CMP_YYLIMIT_LESS_EQ_YYCURSOR => 'CMP_YYLIMIT_LESS_EQ_YYCURSOR';
use constant CMP_YYFILL_0_GOTO            => 'CMP_YYFILL_0_GOTO';
use constant GOTO_YYLABEL                 => 'GOTO_YYLABEL';
use constant INC_YYCURSOR                 => 'INC_YYCURSOR';

my $C_SPACE = qr/( |\t|\v|\f)+/;

sub get_line_type($) {
    local $_ = $_[0];
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
    if (m{\A#line }) {
        return LINE_COMMENT;
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
        return DEFINE_YYLABEL;
    }
    if (m{\A$C_SPACE*\Qyych = *YYCURSOR;\E$C_SPACE*\z}) {
        return ASSIGN_YYCH_YYCURSOR;
    }
    if (m[\A$C_SPACE*\Qif (yych <= 0x\E[0-f]{2}\Q) {\E\z]) {
        return CMP_YYCH_LESS_EQ_CONSTANT;
    }
    if (
        m[\A$C_SPACE*
	\Qif (yych == \E
	(?:0x[a-f]{2}|'[a-z]')
	\Q) goto \E
	(?:yyeof|yy[0-9]+_?);\z]x
      )
    {
        return CMP_YYCH_EQ_CONSTANT_GOTO;
    }
    if (m[\A$C_SPACE*\Qif (YYLIMIT <= YYCURSOR) {\E\z]) {
        return CMP_YYLIMIT_LESS_EQ_YYCURSOR;
    }
    if (
        m[\A$C_SPACE*
	\Qif (YYFILL\E $C_SPACE*
	\Q() == 0) goto \E
	(?:yyeof|yy[0-9]+_?);\z]x
      )
    {
        return CMP_YYFILL_0_GOTO;
    }
    if (m{\A$C_SPACE*goto (?:yyeof|yy[0-9]+_?);\z}) {
        return GOTO_YYLABEL;
    }
    if (m{\A$C_SPACE*\Q++YYCURSOR;\E\z}) {
        return INC_YYCURSOR;
    }
  error:
    die 'failed to parse re2c output';
}

sub pre_processing_re2c_output {
    local $_;
    for my $line (@_) {
        my $type = get_line_type($line);

        #debug
        print "\$type=$type\n";
    }
}

pre_processing_re2c_output(@re2c_output);
