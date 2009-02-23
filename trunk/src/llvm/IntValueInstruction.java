package llvm;

/**
 * llvm: IntValueInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 23, 2009
 */
public class IntValueInstruction extends LLVMInstruction {

    private int regCnt;
    private int value;
    private static String type = "i32";
    public IntValueInstruction(int value, int regCnt)
    {
        this.value = value;
        this.regCnt = regCnt;
    }

    public String toString()
    {
        String s = "%r" + regCnt + " = " + type + " " + value;
        return s;
    }
}
