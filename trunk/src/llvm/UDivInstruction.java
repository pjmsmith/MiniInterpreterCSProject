package llvm;

/**
 * llvm: UDivInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class UDivInstruction extends LLVMInstruction {
    private int leftArg;
    private int rightArg;
    private static final String type = "i32";

    public UDivInstruction(int target, int one, int two)
    {
        super(target, type);
        leftArg = one;
        rightArg = two;

    }

    public int getLeftArg() {
        return leftArg;
    }

    public void setLeftArg(int leftArg) {
        this.leftArg = leftArg;
    }

    public int getRightArg() {
        return rightArg;
    }

    public void setRightArg(int rightArg) {
        this.rightArg = rightArg;
    }

    public String toString()
    {
        String s = "%r" + super.getTargetRegister() + " = udiv " + type + " %r" + leftArg + ", %r" + rightArg;
        return s;
    }
}