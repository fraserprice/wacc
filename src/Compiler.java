import antlr.WACCLexer;
import antlr.WACCParser;
import org.antlr.v4.parse.ANTLRLexer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Compiler {
    public static void main(String[] args) {
        ANTLRFileStream in = null;
        try {
            in = new ANTLRFileStream(args[0]);
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        WACCLexer lexer = new WACCLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WACCParser parser = new WACCParser(tokens);

        ParseTree tree = parser.program();

        System.out.println(tree);
    }
}
