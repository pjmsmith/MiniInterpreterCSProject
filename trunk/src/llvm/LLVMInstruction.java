package llvm;

/**
 * llvm: LLVMInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 23, 2009
 */
public abstract class LLVMInstruction {

    private int targetReg;

    public LLVMInstruction()
    {

    }

    public LLVMInstruction(int tReg)
    {
        targetReg = tReg;
    }

    public int getTargetRegister()
    {
        return targetReg;
    }

    public void setTargetRegister(int tReg)
    {
        targetReg = tReg;
    }
}
