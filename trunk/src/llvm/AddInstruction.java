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
        super(target+2, type);
        leftArg = one;
        rightArg = two;

    }

    public String toString()
    {
        int ptrResultL = super.getTargetRegister()-2;
        int ptrResultR = super.getTargetRegister()-1;
        String s= "%r" + ptrResultL + "= load " + type + "* %r" + leftArg + "\n" +
                "%r" + ptrResultR + "= load " + type + "* %r" + rightArg + "\n" +
        "%r"+ super.getTargetRegister() + " = add " + type + " %r" + ptrResultL + ", %r" + ptrResultR;
        return s;
    }
}
