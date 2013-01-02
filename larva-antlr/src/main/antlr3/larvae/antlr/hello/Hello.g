grammar Hello;

@header {
  package larvae.antlr.hello;
}
@lexer::header {
  package larvae.antlr.hello;
}

program
  : hello* EOF;
hello
  : 'hello' name=Name { System.out.println("Hello, " + $name.text + "!"); };

Name
  : ('a'..'z' | 'A'..'Z' | '0'..'9')+;
WS
  : (' ' | '\t' | '\r' | '\n')+ { skip(); };