lexer grammar BasicLexer;

//operators
PLUS: '+';
MINUS: '-';

//brackets
OPEN_PARENTHESES: '(';
CLOSE_PARENTHESES: ')';

//numbers
fragment DIGIT: '0'..'9';
fragment NON_ZERO_DIGIT: '1'..'9';

INTEGER: NON_ZERO_DIGIT DIGIT*;

// ---------------------------------------------
// skip whitespace
WS: [ \r\n\t]+ -> skip;

// scope block
BEGIN_SCOPE: 'begin';
END_SCOPE: 'end';