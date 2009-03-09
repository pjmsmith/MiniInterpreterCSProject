package llvm;

/**
 * llvm: IdValueInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class IdValueInstruction extends LLVMInstruction {
    private String name;
    private static final String type = "i32";
    private EFrame ef;
    private int lastEF;

    public IdValueInstruction(int target, String name, EFrame e, int lastEF)
    {
        super(target+1, type);
        ef = e;
        this.name = name;
        this.lastEF = lastEF;
    }

    public String toString()
    {
        String s=  "%r" + (super.getTargetRegister()-1) + " = getelementptr %eframe* %r" + lastEF + ", i32 0, i32 " +
            ef.getBinding(name) + "\n";
        s+= "%r" + super.getTargetRegister() + " = load i32* %r" + (super.getTargetRegister()-1);

        return s;
    }
}
