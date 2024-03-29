package llvm;

/**
 * llvm: BoolValueInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 23, 2009
 */
public class BoolValueInstruction extends LLVMInstruction {
    private int value;
    private static final String type = "i32";

    public BoolValueInstruction(int target, boolean value)
    {
        super(target, type);
        if(value)
        {
            this.value = 1;
        }
        else
        {
            this.value = 0;
        }
        this.value = this.value << 3;
        this.value += 7;
    }

    public String toString()
    {
        String s=  "%r" + super.getTargetRegister() + " = alloca " + type;  //make space
        s+= "\nstore " + type + " " + value
                + ", " + type + "* %r" + super.getTargetRegister() + ", align 4";  //store in register
        return s;
    }
}
