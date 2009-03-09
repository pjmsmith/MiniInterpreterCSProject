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
    private int value;
    private static final String type = "i32";

    public IntValueInstruction(int target, int value)
    {
        super(target, type);
        this.value = value << 2;
    }

    public String toString()
    {
        String s=  "%r" + super.getTargetRegister() + " = alloca " + type;  //make space
        s+= "\nstore " + type + " " + value
                + ", " + type + "* %r" + super.getTargetRegister() + ", align 4";  //store in register
        return s;
    }
}
