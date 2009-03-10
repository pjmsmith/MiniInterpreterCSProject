package llvm;

/**
 * llvm: BranchInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class BranchInstruction extends LLVMInstruction {
    private int condition;
    private String trueLabel;
    private String falseLabel;

    public BranchInstruction(int target, int cond, String trueLabel, String falseLabel)
    {
        super(target, "void");
        condition = cond;
        this.trueLabel = trueLabel;
        this.falseLabel = falseLabel;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getTrueLabel() {
        return trueLabel;
    }

    public void setTrueLabel(String trueLabel) {
        this.trueLabel = trueLabel;
    }

    public String getFalseLabel() {
        return falseLabel;
    }

    public void setFalseLabel(String falseLabel) {
        this.falseLabel = falseLabel;
    }

    public String toString()
    {
        String s = "br ";
        if(falseLabel.equals(""))
        {
            s+= "label %" + trueLabel;
        }
        else
        {
            s+= "i1 %r" + condition + ", label %" + trueLabel + ", label %" + falseLabel;
        }
        return s;
    }

}
