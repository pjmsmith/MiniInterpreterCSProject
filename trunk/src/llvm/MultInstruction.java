package llvm;

/**
 * llvm: MultInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 27, 2009
 */
public class MultInstruction extends LLVMInstruction {
    private int leftArg;
    private int rightArg;
    private static final String type = "i32";

    public MultInstruction(int target, int one, int two)
    {
        super(target, type);
        leftArg = one;
        rightArg = two;

    }

    public String toString()
    {
        String s = "%r" + super.getTargetRegister() + " = mul " + type + " %r" + leftArg + ", %r" + rightArg;
        return s;
    }
}
