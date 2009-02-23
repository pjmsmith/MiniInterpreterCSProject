package llvm;

import expression.Expression;
import staticpass.StaticPass;

import java.util.List;

/**
 * llvm: CodeGenerator
 *
 * Description: This class generates the LLVM IR code from the parsed AST.
 *  NOTE: Mutation isn't being represented in LLVM yet, i.e. if(x < 4) { x = x + 1; }
 * 
 * @author Patrick J. Smith
 * @date Feb 4, 2009
 */
public class CodeGenerator {

    private Expression program;
    private List<String> functionNames;
    private List<Integer> functionIDs;


    public CodeGenerator(StaticPass sp)
    {
        program = sp.getProgram();
        functionNames = sp.getFunctionNames();
        functionIDs = sp.getFunctionIds();
    }

    //public CodeObject? generateLLVM(Expression exp)
}
