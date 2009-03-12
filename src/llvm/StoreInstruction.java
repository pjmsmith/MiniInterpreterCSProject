package llvm;

import value.Value;

/**
 * llvm: StoreInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class StoreInstruction extends LLVMInstruction {
    private String value;
    private String valueType;

    public StoreInstruction(int target, String type, String value, String valueType)
    {
        super(target, type);
        this.value = value;
        this.valueType = valueType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString()
    {
        String s = "store " + super.getType() + " " + value;
        if(valueType.equals(""))
        {
             s+= ", i32* %r" + super.getTargetRegister() + ", align 4";
        }
        else
        {
            s+= ", " + valueType + " %r" + super.getTargetRegister() + ", align 4";
        }
        return s;
    }
}
