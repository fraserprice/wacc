import antlr.WACCLexer;
import antlr.WACCParser;
import antlr.WACCParserBaseVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Compiler {
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_FILE_ERROR = 1;
    public static final int EXIT_SYNTAX_ERROR = 100;
    public static final int EXIT_SEMANTIC_ERROR = 200;

    public static void main(String[] args) {
        ANTLRFileStream in = null;
        try {
            in = new ANTLRFileStream(args[0]);
        } catch(IOException e) {
            System.err.println(e.getMessage());
            System.exit(EXIT_FILE_ERROR);
        }

        WACCLexer lexer = new WACCLexer(in);
        lexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WACCParser parser = new WACCParser(tokens);
        parser.removeErrorListeners();

        WACCParserBaseVisitor<Integer> visitor = new WACCParserBaseVisitor<>();

        visitor.visit(parser.program());

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("#syntax_error#");
            System.exit(EXIT_SYNTAX_ERROR);
        }

        System.exit(EXIT_SUCCESS);
    }
}
