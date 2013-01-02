grammar HelloAST;

options {
  output = AST;
  ASTLabelType = CommonTree;
}

@header {
  package larvae.antlr.hello;
}
@lexer::header {
  package larvae.antlr.hello;
}

program
  : hello* EOF;
hello
  : Hello Name -> ^(Hello Name);

Hello
  : 'hello';
Name
  : ('a'..'z' | 'A'..'Z' | '0'..'9')+;
WS
  : (' ' | '\t' | '\r' | '\n')+ { skip(); };