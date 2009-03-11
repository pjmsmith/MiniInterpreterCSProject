package llvm;

/**
 * llvm: LabelInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 11, 2009
 */
public class LabelInstruction extends LLVMInstruction {
    private int labelNum;

    public LabelInstruction(int target, int labelNum)
    {
        super(target, "label");
        this.labelNum = labelNum;
    }

    public int getLabelNum() {
        return labelNum;
    }

    public void setLabelNum(int labelNum) {
        this.labelNum = labelNum;
    }

    public String toString()
    {
        String s = "label_"+labelNum + ":";
        return s;
    }
}
