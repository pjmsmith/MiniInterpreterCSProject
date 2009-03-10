package llvm;

/**
 * llvm: CallInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class CallInstruction extends LLVMInstruction {
    private String name;
    private String args;

    public CallInstruction(int target, String type, String name, String args)
    {
        super(target, type);
        this.name = name;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String toString()
    {
        String s = "%r" + super.getTargetRegister() + " = call " + super.getType() + " @" + name + " (" + args + ")";
        return s;
    }
}
