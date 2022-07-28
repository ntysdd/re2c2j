use v5.12;
use strict;
use warnings;

use IO::Handle qw();

sub get_input_filename {
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

# the input filename
my $filename = get_input_filename();

sub fork_pipe($) {
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
    my @args = ( 're2c', '-s', '--', $filename );
    { exec { $args[0] } @args; }
    close STDOUT;
    die;
}

while (<$to_read>) {
    chomp;

    #TODO
    print $_, "\n";
}

