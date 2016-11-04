import antlr.WACCLexer;
import antlr.WACCParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.gui.SystemFontMetrics;

import java.io.IOException;

public class Compiler {
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_SYNTAX_ERROR = 100;
    public static final int EXIT_SEMANTIC_ERROR = 200;

    public static void main(String[] args) {
        ANTLRFileStream in = null;
        try {
            in = new ANTLRFileStream(args[0]);
        } catch(IOException e) {
            System.out.print(e.getMessage());
            System.exit(EXIT_SYNTAX_ERROR);
        }

        WACCLexer lexer = new WACCLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WACCParser parser = new WACCParser(tokens);


        ParseTree tree = parser.program();

        // System.out.println(tree);
        System.exit(EXIT_SUCCESS);
    }
}
