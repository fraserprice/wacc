package main;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.Map;

public enum CompileTimeError {
    NONE,
    INTEGER_OVERFLOW,
    TYPE_MISMATCH_ERROR, RETURN_STATEMENT_MISSING_FROM_LAST_LINE;

    private static Map<CompileTimeError, String> map = mapInit();
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_FILE_ERROR = 1;
    public static final int EXIT_SYNTAX_ERROR = 100;
    public static final int EXIT_SEMANTIC_ERROR = 200;
    public static boolean hasSemanticErrors = false;

    // TODO Populate errors
    private static Map<CompileTimeError, String> mapInit() {
        Map<CompileTimeError, String> map = new HashMap<CompileTimeError, String>() {{
            put(NONE, "");
            put(INTEGER_OVERFLOW, "Integer Overflow");
            put(TYPE_MISMATCH_ERROR, "Type Mismatch");
            put(RETURN_STATEMENT_MISSING_FROM_LAST_LINE, "Last statement from a function should be a return statement or an exit statement");
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
