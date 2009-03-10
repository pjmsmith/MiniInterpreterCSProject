package llvm;

/**
 * llvm: GetElementPtrInstruction
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 9, 2009
 */
public class GetElementPtrInstruction extends LLVMInstruction {

    private String ptrType;
    private String ptrVal;
    private String location;

    public GetElementPtrInstruction(int target, String ptrType, String ptrVal, String location)
    {
        super(target, "i32*");
        this.ptrType = ptrType;
        this.ptrVal = ptrVal;
        this.location = location;
    }

    public String getPtrType() {
        return ptrType;
    }

    public void setPtrType(String ptrType) {
        this.ptrType = ptrType;
    }

    public String getPtrVal() {
        return ptrVal;
    }

    public void setPtrVal(String ptrVal) {
        this.ptrVal = ptrVal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString()
    {
        String s = "%r" + super.getTargetRegister() + " = getelementptr " + ptrType + " " + ptrVal + " " + location;
        return s;
    }
}

