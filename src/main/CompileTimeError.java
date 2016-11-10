package main;

import antlr.WACCParser;
import java.util.*;
import java.util.stream.Collectors;

public enum CompileTimeError {
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
    INVALID_DIMENSION_NUMBER_ARRAY,
    INVALID_EXIT_ARGUMENT,
    INVALID_VARIABLE_NAME,
    INVALID_PAIR_ELEM_TYPE,
    FUNCTION_NOT_DEFINED,
    NOT_A_FUNCTION,
    WRONG_NUMBER_OF_PARAMS,
    PARAMS_TYPE_DONT_MATCH_WITH_SIGNATURE,
    INVALID_PARAMETER_USE;

    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_FILE_ERROR = 1;
    public static final int EXIT_SYNTAX_ERROR = 100;
    public static final int EXIT_SEMANTIC_ERROR = 200;
    public static boolean hasSemanticErrors = false;
    public static final Set<String> invalidIdentifierVariableNames
        = Arrays.stream(WACCParser.tokenNames)
        .filter(token -> Character.isLowerCase(token.charAt(0)))
        .collect(Collectors.toCollection(HashSet::new));

    public void printSemantic(int line, int characterPos, String... tokens) {
        String errorMessage;

        switch (this) {
            case TYPE_MISMATCH_ERROR:
                errorMessage = "Type Mismatch: Type " + tokens[0] + " " + tokens[1] + " don't match!";
                break;
            case RETURN_STATEMENT_MISSING_FROM_LAST_LINE:
                errorMessage = "Last statement from function should be a return/exit statement!";
                break;
            case RETURN_TYPE_MISMATCH:
                errorMessage = "Expected return type: " + tokens[0] + "; Actual return type: " + tokens[1];
                break;
            case VARIABLE_NOT_DECLARED_IN_THIS_SCOPE:
                errorMessage = "Variable: " + tokens[0] + " not declared in scope!";
                break;
            case UNKNOWN_TYPE:
                errorMessage = "Can't recognize symbol: " + tokens[0];
                break;
            case FORBIDDEN_VARIABLE_NAME:
                errorMessage = "Forbidden variable name: " + tokens[0];
                break;
            case VARIABLE_ALREADY_DEFINED:
                errorMessage = "Variable: " + tokens[0] + " already defined!";
                break;
            case INVALID_FREE_VALUE:
                errorMessage = tokens[0] + " is an invalid free value; Expected: pair!";
                break;
            case INCOMPATIBLE_TYPE:
                errorMessage = tokens[0] + " and " + tokens[1] + " have incompatible types!";
                break;
            case READ_ERROR:
                errorMessage = "Reading a pair is not allowed! Expected: int, char, string, array!";
                break;
            case UNDEFINED_IDENTIFIER:
                errorMessage = tokens[0] + " was not previously defined!";
                break;
            case NOT_VARIABLE:
                errorMessage = tokens[0] + " should be a variable!";
                break;
            case EXPECTED_ARRAY_CALL:
                errorMessage = "Expected: array; Actual: " + tokens[0];
                break;
            case INVALID_DIMENSION_NUMBER_ARRAY:
                errorMessage = "Array reference has different dimensionality from it's declaration!";
                break;
            case INVALID_EXIT_ARGUMENT:
                errorMessage = "Expected: int; Actual: " + tokens[0];
                break;
            case INVALID_VARIABLE_NAME:
                errorMessage = "Illegal variable name for: " + tokens[0];
                break;
            case INVALID_PAIR_ELEM_TYPE:
                errorMessage = "FST/SND expected argument: pair; Actual: " + tokens[0];
                break;
            case FUNCTION_NOT_DEFINED:
                errorMessage = "Function not defined";
                break;
            case NOT_A_FUNCTION:
                errorMessage = tokens[0] + " is not a function!";
                break;
            case WRONG_NUMBER_OF_PARAMS:
                errorMessage = "Wrong number of parameters passed to function!";
                break;
            case PARAMS_TYPE_DONT_MATCH_WITH_SIGNATURE:
                errorMessage = "Type of parameters don't match!";
                break;
            case INVALID_PARAMETER_USE:
                errorMessage = "Invalid declaration of parameter in function definition!";
                break;
            default: errorMessage = null; assert(false): this + " is not a semantic error";
        }

        System.err.println("Error on line " + line + ":" + characterPos + " " + errorMessage);
        hasSemanticErrors = true;
    }

    public void printSyntactic(int line, int characterPos, String... tokens) {
        String errorMessage;

        switch (this) {
            case INTEGER_OVERFLOW: errorMessage = "Integer Overflow: " + tokens[0]; break;
            default: errorMessage = null; assert(false): this + " is not a semantic error";
        }

        System.err.println("Error on line " + line + ":" + characterPos + " " + errorMessage);
    }
}
