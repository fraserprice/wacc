package codegen.instructions;

import codegen.operands.Register;
import codegen.operands.StackLocation;

public class Str {

    private String dest;
    private String stackLocation;
    private boolean isPreIndexAddressed;
    private String src;

    /**
     * This instruction stores in register dest the data in operand 2. This
     * can be either another register, or stack location. This also can
     * contain a flag '!' for applying the offset either before or after the
     * transfer is made.
     */
    public Str(Register dest, StackLocation stackLocation, boolean
            isPreIndexAddressed) {
        this.dest = dest.toString();
        this.stackLocation = stackLocation.toString();
        this.isPreIndexAddressed = isPreIndexAddressed;
    }

    public Str(Register dest, Register src, boolean isPreIndexAddressed) {
        this.dest = dest.toString();
        this.src = src.toString();
        this.isPreIndexAddressed = isPreIndexAddressed;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("STR ").append(dest).append(", ");
        if (stackLocation != null) {
            sb.append(stackLocation);
        } else {
            sb.append("[").append(src).append("]");
        }
        if (isPreIndexAddressed) {
            sb.append("!");
        }
        return sb.toString();
    }
}
