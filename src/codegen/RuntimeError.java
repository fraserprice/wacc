package codegen;

import java.util.LinkedList;

public enum RuntimeError {

    RUNTIME_ERROR,
    OVERFLOW_ERROR,
    STACK_OVERFLOW,
    ARRAY_INDEX_OUT_OF_BOUNDS,
    NULL_POINTER_ERROR,
    DIV_ZERO_ERROR;

    public LinkedList<Instruction> getInstruction() {
        switch(this) {
            case RUNTIME_ERROR:
            case OVERFLOW_ERROR:
            case STACK_OVERFLOW:
            case ARRAY_INDEX_OUT_OF_BOUNDS:
            case NULL_POINTER_ERROR:
            case DIV_ZERO_ERROR:
        }
        return null;
    }

}
