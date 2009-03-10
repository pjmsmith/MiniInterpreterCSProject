package llvm;

/**
 * llvm: LoadInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class LoadInstruction extends LLVMInstruction {
    private int sourcePtr;

    public LoadInstruction(int target, int ptr)
    {
        super(target, "i32");
        sourcePtr = ptr;
    }

    public int getSourcePtr() {
        return sourcePtr;
    }

    public void setSourcePtr(int sourcePtr) {
        this.sourcePtr = sourcePtr;
    }

    public String toString()
    {
        String s = "%r" + super.getTargetRegister() + " = load " + super.getType() + "* %r" + sourcePtr + ", align 4";
        return s;
    }
}
