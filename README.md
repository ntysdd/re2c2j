# re2c2j

### What is re2c2j

re2c2j is a translator for re2c -- it translates re2c-generated C code into Java code.

If you just want to use regular expressions in Java, see https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html or https://github.com/google/re2j.

### What is re2c

re2c is a lexer generator. It compiles regular expression specifications into automata and encodes them into target language.

At the time of writing, supported target languages are C/C++, Rust and Go. (https://re2c.org and https://github.com/skvadrik/re2c)


### How is code translated

re2c2j currently translates generated code line by line, adding necessary surrounding code.

`goto` statements are translated into `while` and `switch`, which hopefully will be JIT-compiled into equiv machine code.

Pointers are translated into array indices.

Only `--nested-ifs` mode is supported.


### What are the dependencies

Perl and re2c are required to run this project.
Currently re2c2j is implemented in Perl, which is included in almost every Linux distribution.
re2c is also required, which should be in PATH when re2c2j is started.

At the time of writing, only Perl v5.30 and re2c v1.3 are tested.
Windows platform is not tested. It's not clear whether Perl's fork emulation is good enough for this. WSL is good though.

### Usage:
```
$ perl re2c2j.pl input.in > output.out
```

### Project Status
Now re2c2j is in its very-early phase.

Very few re2c options or features are supported.

Don't be surprised to see `failed to parse re2c output ...`.
