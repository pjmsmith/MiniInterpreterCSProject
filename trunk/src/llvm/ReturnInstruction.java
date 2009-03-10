package llvm;

/**
 * llvm: ReturnInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 27, 2009
 */
public class ReturnInstruction extends LLVMInstruction {
    private String type;
    private int value;

    public ReturnInstruction(String type, int value)
    {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString()
    {
        String s = "ret " + type + " %r" + value; 
        return s;
    }
}

