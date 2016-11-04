parser grammar WACCParser;

options {
  tokenVocab = WACCLexer;
}

// EOF indicates that the program must consume to the end of the input.
program: BEGIN_STAT func* stat END_STAT EOF
       ;

func: type IDENT OPEN_PARENTHESES paramList? CLOSE_PARENTHESES IS (stat)* END_STAT
    ;

paramList: param (COMMA param)*
         ;

param: type IDENT
     ;

stat: SKIP_STAT                                           #SkipStat
    | type IDENT ASSIGN_STAT assignRhs                    #AssignPrimitiveStat
    | assignLhs ASSIGN_STAT assignRhs                     #AssignPairArrayStat
    | READ_STAT assignLhs                                 #ReadStat
    | FREE_STAT expr                                      #FreeStat
    | RETURN_STAT expr                                    #ReturnStat
    | EXIT_STAT expr                                      #ExitStat
    | PRINT_STAT expr                                     #PrintStat
    | PRINTLN_STAT expr                                   #PrintlnStat
    | IF_STAT expr THEN_STAT stat ELSE_STAT stat FI_STAT  #IfStat
    | WHILE_STAT expr DO_STAT stat DONE_STAT              #WhileStat
    | BEGIN_STAT stat END_STAT                            #ScopeBlockStat
    | stat COMPOSITION_STAT stat                          #CompositionStat
    ;

assignLhs: IDENT
         | arrayElem
         | pairElem
         ;

assignRhs: expr
         | arrayLiteral
         | NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
         | pairElem
         | CALL_FUNC IDENT OPEN_PARENTHESES argList? CLOSE_PARENTHESES
         ;

argList: expr (COMMA expr)*
       ;

pairElem: FST expr
        | SND expr
        ;

type: baseType
    | type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    | pairType
    ;

baseType: INT
        | BOOL
        | CHAR
        | STRING
        ;

pairType: PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES
        ;

pairElemType: baseType
			| type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
			| PAIR
			;

expr: OPEN_PARENTHESES expr CLOSE_PARENTHESES            #ParanthesesExpr
    | PLUS INT_LITERAL                                   #UnPlusExpr
	| (MINUS|NOT|LEN|CHR|ORD) expr                       #UnExpr
	| expr (MULTIPLY|DIVISION|MODULO) expr               #BinMulDivModExpr
	| expr (PLUS|MINUS) expr                             #BinPlusMinusExpr
	| expr (GREATER|GREATER_EQ|SMALLER|SMALLER_EQ) expr  #BinCompExpr
	| expr (EQ|NOT_EQ) expr                              #BinEqExpr
	| expr AND expr                                      #BinAndExpr
	| expr OR expr                                       #BinOrExpr
	| arrayElem                                          #ArrayExpr
	| literal                                            #LiteralExpr
	| IDENT                                              #IdentExpr
	;

literal: INT_LITERAL
	   | BOOL_LITERAL
	   | CHAR_LITERAL
	   | STR_LITERAL
	   | PAIR_LITERAL
	   ;

arrayElem: IDENT (OPEN_SQUARE_BRACKET expr CLOSE_SQUARE_BRACKET)+
         ;

arrayLiteral: OPEN_SQUARE_BRACKET (expr (COMMA expr)*)? CLOSE_SQUARE_BRACKET
            ;
