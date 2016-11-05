import java.util.HashMap;
import java.util.Map;

public enum Error {
    // TODO
    VARIABLE_NOT_DECLARED;
    private static Map<Error, String> map = mapInit();

    private static Map<Error, String> mapInit() {
        Map<Error, String> map = new HashMap<>();

        // TODO

        return map;
    }

    public void print() {
        System.err.println(map.get(this));
    }
}
