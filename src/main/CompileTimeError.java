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
    WRONG_NUMBER_OF_PARAMS,
    PARAMS_TYPE_DONT_MATCH_WITH_SIGNATURE,
    ARRAY_LITERAL_TYPE_DONT_MATCH,
    MAIN_FUNCTION_CONTAINS_RETURN,
    FUNCTION_ALREADY_DEFINED,
    INVALID_OPERANDS;

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
            case INVALID_OPERANDS:
                errorMessage = "Operator " + tokens[0]
                        + " doesn't work on " + tokens[1];
                break;
            case FUNCTION_ALREADY_DEFINED:
                errorMessage = "Function "
                        + tokens[0] + " already defined";
                break;
            case MAIN_FUNCTION_CONTAINS_RETURN:
                errorMessage
                        = "Main block can't have return statements";
                break;
            case ARRAY_LITERAL_TYPE_DONT_MATCH:
                errorMessage
                        = "Elements in array literal don't have the same type";
                break;
            case TYPE_MISMATCH_ERROR:
                errorMessage = "Type Mismatch: Types " + tokens[0] + " and "
                        + tokens[1] + " don't match!";
                break;
            case RETURN_TYPE_MISMATCH:
                errorMessage = "Expected return type: " + tokens[0]
                        + ", actual return type: " + tokens[1];
                break;
            case VARIABLE_NOT_DECLARED_IN_THIS_SCOPE:
                errorMessage = "Variable: " + tokens[0]
                        + " not declared in this scope!";
                break;
            case VARIABLE_ALREADY_DEFINED:
                errorMessage = "Variable: " + tokens[0] + " already defined!";
                break;
            case INVALID_FREE_VALUE:
                errorMessage = tokens[0]
                        + " is an invalid free value (expected: pair)!";
                break;
            case INCOMPATIBLE_TYPE:
                errorMessage = tokens[0] + " of type " + tokens[1] + " and "
                        + tokens[2] + " of type " + tokens[3]
                        + " have incompatible types!";
                break;
            case READ_ERROR:
                errorMessage = "Reading a " + tokens[0]
                        + " is not valid. (expected: INT or CHAR)";
                break;
            case UNDEFINED_IDENTIFIER:
                errorMessage = tokens[0] + " was not previously defined!";
                break;
            case NOT_VARIABLE:
                errorMessage = tokens[0] + " should be a variable!";
                break;
            case EXPECTED_ARRAY_CALL:
                errorMessage = "Expected: array, Actual: " + tokens[0];
                break;
            case INVALID_DIMENSION_NUMBER_ARRAY:
                errorMessage = "Array reference has different dimensionality" +
                        " from it's declaration!";
                break;
            case INVALID_EXIT_ARGUMENT:
                errorMessage = "Expected: INT, actual: " + tokens[0];
                break;
            case INVALID_VARIABLE_NAME:
                errorMessage = "Illegal variable name for: " + tokens[0];
                break;
            case INVALID_PAIR_ELEM_TYPE:
                errorMessage = "FST/SND expected argument: pair, actual: "
                        + tokens[0];
                break;
            case FUNCTION_NOT_DEFINED:
                errorMessage = "Function " + tokens[0] + " not defined.";
                break;
            case WRONG_NUMBER_OF_PARAMS:
                errorMessage = "Wrong number of parameters passed to function!"
                        + " (expected: " + tokens[0] + ", actual: "
                        + tokens[1] + ")";
                break;
            case PARAMS_TYPE_DONT_MATCH_WITH_SIGNATURE:
                errorMessage = "Parameter at position " + tokens[0] +
                        " doesn't match with function " + tokens[1] +
                        " signature (expected: " + tokens[2] + ", actual: "
                        + tokens[3] + ")";
                break;
            default:
                errorMessage = null;
                assert (false) : this +
                        " is not a semantic error";
        }

        System.err.println("Error on line " + line + ":" + characterPos +
                " " + errorMessage);
        hasSemanticErrors = true;
    }

    public void printSyntactic(int line, int characterPos, String... tokens) {
        String errorMessage;
        switch (this) {
            case INTEGER_OVERFLOW:
                errorMessage = "Integer Overflow: " +
                        tokens[0];
                break;
            case RETURN_STATEMENT_MISSING_FROM_LAST_LINE:
                errorMessage = "Last statement from function should be a"
                        + " return/exit statement!";
                break;
            default:
                errorMessage = null;
                assert (false) : this +
                        " is not a semantic error";
        }

        System.err.println("Error on line " + line + ":" + characterPos +
                " " + errorMessage);
    }
}
