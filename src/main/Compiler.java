package main;

import antlr.WACCLexer;
import antlr.WACCParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import visitor.SemanticVisitor;

import java.io.IOException;

public class Compiler {
    public static void main(String[] args) {
        ANTLRFileStream in = null;
        try {
            in = new ANTLRFileStream(args[0]);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(CompileTimeError.EXIT_FILE_ERROR);
        }

        WACCLexer lexer = new WACCLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WACCParser parser = new WACCParser(tokens);

        // Syntax check
        ParseTree tree = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
        }

        // Syntax and Semantic check
        SemanticVisitor visitor = new SemanticVisitor();
        visitor.visit(tree);


        if (CompileTimeError.hasSemanticErrors) {
            System.exit(CompileTimeError.EXIT_SEMANTIC_ERROR);
        }

        System.exit(CompileTimeError.EXIT_SUCCESS);
    }
}
