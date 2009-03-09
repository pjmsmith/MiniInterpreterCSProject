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
    private String type;

    public LLVMInstruction()
    {

    }

    public LLVMInstruction(int tReg, String type)
    {
        targetReg = tReg;
        this.type = type;
    }

    public int getTargetRegister()
    {
        return targetReg;
    }

    public void setTargetRegister(int tReg)
    {
        targetReg = tReg;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String s) {
        type = s;
    }
}
