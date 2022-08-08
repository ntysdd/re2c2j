# re2c2j

re2c2j is a translator for re2c -- it translates re2c-generated C code into Java code.

### What is re2c

re2c is a lexer generator. It compiles regular expression specifications into automata and encodes them into target language. At the time of writing, supported target languages are C, Rust and Go. (https://re2c.org)

### How is code translated

re2c2j currently translates generated code line by line, adding necessary surrounding code.
`goto` statements are translated to `while` and `switch`, which hopefully will be JIT-compiled into equiv machine code.

### What's the dependency

Currently re2c2j is implemented in Perl, which is almost included into every Linux distribution.
re2c is also required, which should be in PATH when re2c2j is started.

At the time of writing, only Perl v5.30 and re2c v1.3 are tested.

### Usage:
```
$ perl re2c2j.pl input.in > output.out
```

