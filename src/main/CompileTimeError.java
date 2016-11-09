package main;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CompileTimeError {
    NONE,
    INTEGER_OVERFLOW,
    TYPE_MISMATCH_ERROR,
    RETURN_STATEMENT_MISSING_FROM_LAST_LINE,
    RETURN_TYPE_MISMATCH,
    VARIABLE_NOT_DECLARED_IN_THIS_SCOPE,
    UNKNOWN_TYPE,
    FORBIDDEN_VARIABLE_NAME,
    VARIABLE_ALREADY_DEFINED,
    INVALID_FREE_VALUE,
    INCOMPATIBLE_TYPE,
    READ_ERROR,
    UNDEFINED_IDENTIFIER,
    NOT_VARIABLE,
    EXPECTED_ARRAY_CALL,
    INVALID_DIMENSION_NUMBER_ARRAY, INVALID_EXIT_ARGUMENT, INVALID_VARIABLE_NAME;

    private static Map<CompileTimeError, String> map = mapInit();
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_FILE_ERROR = 1;
    public static final int EXIT_SYNTAX_ERROR = 100;
    public static final int EXIT_SEMANTIC_ERROR = 200;
    public static boolean hasSemanticErrors = false;
    public static final Set<String> invalidIdentifierVariableNames = Stream.of(
            "'is'", "'call'", "'skip'", "'read'", "'free'", "'return'", "'exit'", "'print'",
            "'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'",
            "'begin'", "'end'", "';'", "'int'", "'bool'", "'char'", "'string'", "'newpair'",
            "'pair'", "'fst'", "'snd'", "'len'", "'ord'", "'chr'","'null'")
            .collect(Collectors.toCollection(HashSet::new));

    // TODO Populate errors
    private static Map<CompileTimeError, String> mapInit() {
        Map<CompileTimeError, String> map = new HashMap<CompileTimeError, String>() {{
            put(NONE, "");
            put(INTEGER_OVERFLOW, "Integer Overflow");
            put(TYPE_MISMATCH_ERROR, "Type Mismatch");
            put(RETURN_STATEMENT_MISSING_FROM_LAST_LINE, "Last statement from a function should be a return statement or an exit statement");
            put(RETURN_TYPE_MISMATCH, "Function return type is incompatible with return type");
            put(VARIABLE_NOT_DECLARED_IN_THIS_SCOPE, "Variable not declared in this scope");
            put(UNKNOWN_TYPE, "Unknown type");
            put(FORBIDDEN_VARIABLE_NAME, "Forbidden variable name");
            put(VARIABLE_ALREADY_DEFINED, "Variable is already defined");
            put(INVALID_FREE_VALUE, "Can't free a non-pair variable");
            put(INCOMPATIBLE_TYPE, "Incompatible types to compare");
            put(READ_ERROR, "Can't read a pair variable");
            put(UNDEFINED_IDENTIFIER, "Variable was not previously declared");
            put(NOT_VARIABLE, "Identifier should be a variable");
            put(EXPECTED_ARRAY_CALL, "Expected array got something else");
            put(INVALID_DIMENSION_NUMBER_ARRAY, "Array reference has different dimensionality from it's declaration");
            put(INVALID_EXIT_ARGUMENT, "Exit statement takes an int as an argument");
            put(INVALID_VARIABLE_NAME, "Illegal variable name");
        }};

        return map;
    }

    public void printSemantic(ParserRuleContext ctx) {
        System.err.println("Error on line " + ctx.getStart().getLine()
                + ":" + ctx.getStart().getCharPositionInLine() + " " + map.get(this));
        hasSemanticErrors = true;
    }

    public void printSyntactic(ParserRuleContext ctx) {
        System.err.println("Error on line " + ctx.getStart().getLine()
                + ":" + ctx.getStart().getCharPositionInLine() + " " + map.get(this));
    }
}
