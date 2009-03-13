package llvm;

/**
 * llvm: PhiNodeInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 13, 2009
 */
public class PhiNodeInstruction extends LLVMInstruction {
    private String valsAndLabels;

    //<result> = phi <ty> [ <val0>, <label0>], ...
    public PhiNodeInstruction(int target, String type, String valsAndLabels)
    {
        super(target, type);
        this.valsAndLabels = valsAndLabels;
    }

    public String getValsAndLabels() {
        return valsAndLabels;
    }

    public void setValsAndLabels(String valsAndLabels) {
        this.valsAndLabels = valsAndLabels;
    }

    public String toString()
    {
        String s = "%r"+super.getTargetRegister() + " = phi " + super.getType() + " " + valsAndLabels;
        return s;
    }
}
