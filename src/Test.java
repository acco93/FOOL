import java.io.BufferedWriter;
import java.io.FileWriter;

import org.antlr.runtime.*;

public class Test {
    public static void main(String[] args) throws Exception {
  
        String fileName = "prova.fool";
     
        ANTLRFileStream input = new ANTLRFileStream(fileName);
        FOOLLexer lexer = new FOOLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FOOLParser parser = new FOOLParser(tokens);

        
        Node ast = parser.prog();
        System.out.println(ast.toPrint(""));
        
        // mi fa il typechecking e ritorna il tipo della radice se tutto va bene
        Node type = ast.typeCheck();
        System.out.println("[RIGHT] You have: "+lexer.lexicalErrors+" lexical errors and "+parser.getNumberOfSyntaxErrors()+" syntax errors.");
        System.out.println(type.toPrint("Type checking successful! Program type: "));
        
        String code = ast.codeGeneration();
              
        
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm")); 
        out.write(code);
        out.close();
        
        ANTLRFileStream inputVM = new ANTLRFileStream(fileName+".asm");
        SVMLexer lexerVM = new SVMLexer(inputVM);
        CommonTokenStream tokensVM = new CommonTokenStream(lexerVM);
        SVMParser parserVM = new SVMParser(tokensVM);
        
        System.out.println("Code successfully generated!");
        System.out.println("Assembling and running generated code.\n--------------------\n");
        
        
        parserVM.assembly();
        
        ExecuteVM vm = new ExecuteVM(parserVM.code);
        vm.cpu();
        
                
    }
}
