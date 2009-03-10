package llvm;

/**
 * llvm: AssignInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 27, 2009
 */
public class AssignInstruction extends LLVMInstruction {
    private String leftSide;
    private int rightSide;
    private EFrame ef;

    public AssignInstruction(String s, int nextReg, String l, int r, EFrame ef) {
        super(nextReg, s);
        super.setType(s);
        leftSide = l;
        rightSide = r;
        this.ef = ef;
    }

    public String toString()
    {
        String s = "%r" + (super.getTargetRegister()-1) + " = getelementptr %eframe* %r1, i32 0, i32 " +
                ef.getBinding(leftSide) + "\n";
        s+= "%r" + (super.getTargetRegister()) + " = load i32* %r" + (rightSide-1) + "\n";
        s+= "store i32 %r" + (super.getTargetRegister()) + ", i32* %r" + (super.getTargetRegister()-1) + ", align 4";
        return s;
    }
}
