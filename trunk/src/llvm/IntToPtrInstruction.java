package llvm;

/**
 * llvm: IntToPtrInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 13, 2009
 */
public class IntToPtrInstruction extends LLVMInstruction {
    private String value;
    private String type1;

    public IntToPtrInstruction(int target, String type1, String value, String type2)
    {
        super(target, type2);
        this.type1 = type1;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String toString()
    {
        String s = "%r" + super.getTargetRegister() + " = inttoptr " + type1 + " " + value + " to " + super.getType();
        return s;
    }
}
