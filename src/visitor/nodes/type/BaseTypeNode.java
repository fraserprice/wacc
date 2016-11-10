package visitor.nodes.type;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.Node;

public class BaseTypeNode extends Node<WACCParser.BaseTypeContext> {
    private TypeObj type;

    public BaseTypeNode(SymbolTable currentST, WACCParser.BaseTypeContext ctx) {
        super(currentST, ctx);
        switch (ctx.getText()) {
            case "int": type = currentST.lookupAll("int", IntObj.class);break;
            case "bool": type = currentST.lookupAll("bool", BoolObj.class);break;
            case "char": type = currentST.lookupAll("char", CharObj.class);break;
            case "string": type = currentST.lookupAll("string", ArrayObj.class);break;
            default:assert(false);
        }
    }

    public TypeObj getType() {
        return type;
    }
}
