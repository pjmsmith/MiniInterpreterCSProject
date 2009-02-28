package llvm;

/**
 * llvm: AssignInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 27, 2009
 */
public class AssignInstruction extends LLVMInstruction {
    private int leftSide;
    private int rightSide;
    private static String type;

    public AssignInstruction(String s, int nextReg, int l, int r) {
        super(nextReg);
        type = s;
    }

    public String toString()
    {
        String s = "ASSIGN";
        return s;
    }
}
