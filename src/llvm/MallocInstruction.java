package llvm;

/**
 * llvm: MallocInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class MallocInstruction extends LLVMInstruction {

    private String size;

    public MallocInstruction(int target, String type, String size)
    {
        super(target, type);
        this.size = size;

    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String toString()
    {
        String s = "%r" + super.getTargetRegister() + " = malloc " + super.getType();
        if(!size.equals(""))
        {
            s+= ", " + size;
        }
        s+= ", align 4";
        return s;
    } 
}
