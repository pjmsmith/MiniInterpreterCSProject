package llvm;

/**
 * llvm: ICmpInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class ICmpInstruction extends LLVMInstruction {
    private String condition;
    private int op1;
    private int op2;

    public ICmpInstruction(int target, String cond, int op1, int op2)
    {
        super(target, "i1");
        condition = cond;
        this.op1 = op1;
        this.op2 = op2;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getOp1() {
        return op1;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }

    public String toString()
    {
        String s = "%r" + super.getTargetRegister() + " = icmp " + condition + " i32 %r" + op1 + ", %r" + op2;
        return s;
    }
}
