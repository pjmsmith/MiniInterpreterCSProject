package llvm;

/**
 * llvm: PrintInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 27, 2009
 */
public class PrintInstruction extends LLVMInstruction {

    private static final String funcall = "printf";

    public PrintInstruction()
    {

    }
    //call i32 (i8*, ...)* @printf(i8* noalias getelementptr ([4 x i8]* @.str, i32 0, i32 0), i32 %1) nounwind
    public String toString()
    {
        String s = "";
        s+= "";
        return s;
    }
}
