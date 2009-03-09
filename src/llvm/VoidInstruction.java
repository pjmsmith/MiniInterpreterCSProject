package llvm;

/**
 * llvm: VoidInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 27, 2009
 */
public class VoidInstruction extends LLVMInstruction {
    private int value;
    private static final String type = "i32";

    public VoidInstruction(int target)
    {
        super(target, type);
        value = 3;
    }

    public String toString()
    {
        String s=  "%r" + super.getTargetRegister() + " = alloca " + type;  //make space
        s+= "\nstore " + type + " 0x" + Integer.toHexString(value).toUpperCase()
                + ", " + type + "* %" + super.getTargetRegister() + ", align 4";  //store in register
        return s;
    }
}

