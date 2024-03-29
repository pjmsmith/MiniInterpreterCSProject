package llvm;

/**
 * llvm: ShiftLeftInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class ShiftLeftInstruction extends LLVMInstruction {
    private int value;
    private int numShifts;

    public ShiftLeftInstruction(int target, int value, int numShifts)
    {
        super(target, "i32");
        this.value = value;
        this.numShifts = numShifts;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumShifts() {
        return numShifts;
    }

    public void setNumShifts(int numShifts) {
        this.numShifts = numShifts;
    }

    public String toString()
    {
        String s = "%r" + super.getTargetRegister() + " = shl " + super.getType() + " %r" + value + ", " + numShifts;
        return s;
    }
}
