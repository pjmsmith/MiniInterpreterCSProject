package llvm;

import java.util.ArrayList;

/**
 * llvm: Closure
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Mar 12, 2009
 */
public class Closure {
    private int numElements;
    private ArrayList<String> idList;
    private ArrayList<String> functionNameList;

    public Closure()
    {
        numElements = 0;
        idList = new ArrayList<String>();
        functionNameList = new ArrayList<String>();
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

    public String lookupBinding(String idVal)
    {
        String b = "";
        for(int i = 0; i < numElements; i++)
        {
            if(idVal.equals(idList.get(i)))
            {
                b = functionNameList.get(i);
                break;
            }
        }
        return b;
    }

    public void addBinding(String id, String funName)
    {
        idList.add(id);
        functionNameList.add(funName);
        numElements++;
    }
}
