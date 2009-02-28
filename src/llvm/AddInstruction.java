package llvm;

/**
 * llvm: AddInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 27, 2009
 */
public class AddInstruction extends LLVMInstruction {
    private int leftArg;
    private int rightArg;
    private static final String type = "i32";

    public AddInstruction(int target, int one, int two)
    {
        super(target);
        leftArg = one;
        rightArg = two;

    }

    public String toString()
    {
        String s= "%"+ super.getTargetRegister() + " = add " + type + " %" + leftArg + ", %" + rightArg;
        return s;
    }
}
