package llvm;

/**
 * llvm: EFrameInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class EFrameInstruction extends LLVMInstruction {
    private static final String type = "i32";
    private EFrame ef;
    public EFrameInstruction(int target, EFrame ef)
    {
        super(target+1, type);
        this.ef = ef;
    }

    public String toString()
    {
        String s=  "%r" + (super.getTargetRegister()-1) + " = malloc {%eframe*, i32, [" + ef.getNumElements() +
            " x i32]}, align 4\n";
        s+= "%r" + (super.getTargetRegister()) + " = bitcast {%eframe*, i32, ["+ ef.getNumElements() +
                " x i32]}* %r" + (super.getTargetRegister()-1) + " to %eframe*\n";

        return s;
    }
}
