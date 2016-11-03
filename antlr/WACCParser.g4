parser grammar WACCParser;

options {
  tokenVocab = WACCLexer;
}

// EOF indicates that the program must consume to the end of the input.
program: BEGIN_STAT func* stat END_STAT EOF;

func: type IDENT OPEN_PARENTHESES param_list? CLOSE_PARENTHESES IS stat END_STAT;

param_list: param (COMMA param)*;

param: type IDENT;

stat: SKIP_STAT
| type IDENT ASSIGN_STAT assign_rhs
| assign_lhs ASSIGN_STAT assign_rhs
| READ_STAT assign_lhs
| FREE_STAT expr
| RETURN_STAT expr
| EXIT_STAT expr
| PRINT_STAT expr
| PRINTLN_STAT expr
| IF_STAT expr THEN_STAT stat ELSE_STAT stat FI_STAT
| WHILE_STAT expr DO_STAT stat DONE_STAT
| BEGIN_STAT stat END_STAT
| stat COMPOSITION_STAT stat
;

assign_lhs: IDENT
| array_elem
| pair_elem
;

assign_rhs: expr
| array_literal
| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
| pair_elem
| CALL_FUNC IDENT OPEN_PARENTHESES arg_list? CLOSE_PARENTHESES
;

arg_list: expr (COMMA expr)*;

pair_elem: FST expr | SND expr;

type: base_type
| type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
| pair_type
;

base_type: INT
| BOOL
| CHAR
| STRING
;

pair_type: PAIR OPEN_PARENTHESES pair_elem_type COMMA pair_elem_type CLOSE_PARENTHESES;

pair_elem_type: base_type
| type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
| PAIR
;

expr: OPEN_PARENTHESES expr CLOSE_PARENTHESES
| (PLUS|MINUS|NOT|LEN|CHR|ORD) expr
| expr (MULTIPLY|DIVISION|MODULO) expr
| expr (PLUS|MINUS) expr
| expr (GREATER|GREATER_EQ|SMALLER|SMALLER_EQ) expr
| expr (EQ|NOT_EQ) expr
| expr AND expr
| expr OR expr
| array_elem
| literal
| IDENT
;

literal: INT_LITERAL
| BOOL_LITERAL
| CHAR_LITERAL
| STR_LITERAL
| PAIR_LITERAL
;

array_elem: IDENT (OPEN_SQUARE_BRACKET expr CLOSE_SQUARE_BRACKET)+;

array_literal: OPEN_SQUARE_BRACKET (expr (COMMA expr)*)? CLOSE_SQUARE_BRACKET;
