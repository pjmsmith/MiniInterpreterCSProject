package llvm;

import value.Value;

import java.util.ArrayList;

/**
 * llvm: EFrame
 * <p/>
 * Description:
 *
 * @author Patrick J. Smith
 * @date Feb 27, 2009
 */
public class EFrame {
    private int numElements;
    private ArrayList<Value> elementList;
    private ArrayList<String> elementNames;
    private EFrame previous;

    public EFrame(EFrame previous)
    {
        this.previous = previous;
        numElements = 0;
        elementList = new ArrayList<Value>();
        elementNames = new ArrayList<String>();
    }

    public void addBinding(String name, Value val)
    {
        elementList.add(val);
        elementNames.add(name);
        numElements++;
    }

    public int getBinding(String name)
    {
        int binding = 0;
        for(int i = 0; i < numElements; i++)
        {
            if(elementNames.get(i).equals(name))
            {
                binding = i;
                break;
            }
        }
        return binding;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

    public ArrayList<Value> getElementList() {
        return elementList;
    }

    public void setElementList(ArrayList<Value> elementList) {
        this.elementList = elementList;
    }

    public ArrayList<String> getElementNames() {
        return elementNames;
    }

    public void setElementNames(ArrayList<String> elementNames) {
        this.elementNames = elementNames;
    }

    public EFrame getPrevious() {
        return previous;
    }

    public void setPrevious(EFrame previous) {
        this.previous = previous;
    }
}
