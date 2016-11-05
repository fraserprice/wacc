package visitor;

import java.util.HashMap;
import java.util.Map;

public enum CompileTimeError {
    // TODO
    None,
    VariableNotDeclaredError;
    private static Map<CompileTimeError, String> map = mapInit();

    // TODO Populate errors
    private static Map<CompileTimeError, String> mapInit() {
        Map<CompileTimeError, String> map = new HashMap<CompileTimeError, String>() {{
            put(None, "");
            put(VariableNotDeclaredError, "Error template!!");
        }};

        return map;
    }

    public void print() {
        System.err.println(map.get(this));
    }
}
