package llvm;

import java.util.ArrayList;

/**
 * llvm: FunctionDeclarationInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class FunctionDeclarationInstruction extends LLVMInstruction {

    private String arguments;
    private String name;
    private ArrayList<LLVMInstruction> body;

    public FunctionDeclarationInstruction(int target, String type, String name,
                                          String arguments, ArrayList<LLVMInstruction> body)
    {
        super(target, type);
        this.arguments = arguments;
        this.name = name;
        this.body = body;

    }


    public String toString()
    {
        String s = "define " + super.getType() + " @" + name + " (%eframe* %env, " + arguments + ") { \n";
        for(LLVMInstruction l: body)
        {
            s+= "\t" + l + "\n";
        }
        s+= "}\n";
        s+= "define " + super.getType() + " @" + name + "_m (%eframe* %env, i32 %this, "  + arguments + ") { \n";
        for(LLVMInstruction l: body)
        {
            s+= "\t" + l + "\n";
        }
        s+= "}\n";
        return s;
    }

}
