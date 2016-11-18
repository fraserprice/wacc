package codegen;

public class LabelIns implements Instruction {
    private String name;

    public LabelIns(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ":\n";
    }
}
