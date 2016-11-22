package codegen.instructions;

import symobjects.identifierobj.TypeObj;

// All the Instructions defined for WACC
public enum Ins {
    ADD, ADDS, AND, ASR, B, BEQ, BL, BLCS, BLEQ, BLLT, BLNE, BLVS, CMP, EOR, LDR, LDRCS, LDREQ, LDRLT, LDRNE, LDRSB, MOV,
    MOVEQ, MOVGE, MOVGT, MOVLE, MOVLT, MOVNE, ORR, POP, PUSH, RSBS, SMULL, STR, STRB, SUB, SUBS, LSL;

    public static Ins getStrInstruciton(TypeObj type) {
        if (type.getSize() == 1) {
            return Ins.STRB;
        } else {
            return Ins.STR;
        }
    }

    public static Ins getLdrInstruction(TypeObj type) {
        if (type.getSize() == 1) {
            return Ins.LDRSB;
        } else {
            return Ins.LDR;
        }
    }
}
