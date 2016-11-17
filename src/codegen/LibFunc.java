package codegen;

import java.util.ArrayList;
import java.util.List;

public abstract class LibFunc {
    protected DataDir dataDir;

    public LibFunc(DataDir dataDir) {
        this.dataDir = dataDir;
    }

    public List<Class<? extends LibFunc>> getDependencies() {
        return new ArrayList<>();
    }

    public abstract List<Instruction> getInstructions();
}
