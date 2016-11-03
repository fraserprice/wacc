lexer grammar WACCLexer;

// skip all whitespace and comments
WS: [ \r\n\t]+ -> skip;
COMMENT: '#' ~[\n]* '\n' -> skip;

//brackets
OPEN_PARENTHESES: '(';
CLOSE_PARENTHESES: ')';
OPEN_SQUARE_BRACKET: '[';
CLOSE_SQUARE_BRACKET: ']';

// function definition
IS: 'is';
COMMA: ',';
CALL_FUNC: 'call';

// statements
SKIP_STAT: 'skip';
ASSIGN_STAT: '=';
READ_STAT: 'read';
FREE_STAT: 'free';
RETURN_STAT: 'return';
EXIT_STAT: 'exit';
PRINT_STAT: 'print';
PRINTLN_STAT: 'println';
IF_STAT: 'if';
THEN_STAT: 'then';
ELSE_STAT: 'else';
FI_STAT: 'fi';
WHILE_STAT: 'while';
DO_STAT: 'do';
DONE_STAT: 'done';
BEGIN_STAT: 'begin';
END_STAT: 'end';
COMPOSITION_STAT: ';';

// program literals
INT: 'int';
BOOL: 'bool';
CHAR: 'char';
STRING: 'string';

NEWPAIR: 'newpair';
PAIR: 'pair';
FST: 'fst';
SND: 'snd';

// unary operators
NOT: '!';
MINUS: '-';
LEN: 'len';
ORD: 'ord';
CHR: 'chr';

// binary operators
MULTIPLY: '*';
DIVISION: '/';
MODULO: '%';
PLUS: '+';
GREATER: '>';
GREATER_EQ: '>=';
SMALLER: '<';
SMALLER_EQ: '<=';
EQ: '==';
NOT_EQ: '!=';
AND: '&&';
OR: '||';

// identifiers
fragment DIGIT: '0'..'9';
fragment ESCAPED_CHAR: '0'|'b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\';
fragment CHARACTER: ~['\\''\'''"']|'\\' ESCAPED_CHAR;
IDENT: ('_'|'a'..'z'|'A'..'Z')('_'|'a'..'z'|'A'..'Z'|'0'..'9')*;
INT_LITERAL: DIGIT+;
BOOL_LITERAL: 'true' | 'false';
CHAR_LITERAL: '\'' CHARACTER '\'';
STR_LITERAL: '"' CHARACTER* '"';
PAIR_LITERAL: 'null';