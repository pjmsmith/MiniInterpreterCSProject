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
    private ArrayList<Integer> elementList;
    private ArrayList<String> elementNames;
    private EFrame previous;
    private int numScopesBack;

    public EFrame(EFrame previous)
    {
        this.previous = previous;
        numElements = 0;
        elementList = new ArrayList<Integer>();
        elementNames = new ArrayList<String>();
        numScopesBack = 0;
    }

    public void addBinding(String name, Integer val)
    {
        elementList.add(val);
        elementNames.add(name);
        numElements++;
    }

    public int getBinding(String name)
    {
        int binding = -1;
        EFrame next = this;
        numScopesBack = 0;
        while(next != null)
        {
            for(int i = 0; i < next.getNumElements(); i++)
            {
                if(next.getElementNames().get(i).equals(name))
                {
                    binding = i;
                    break;
                }
            }
            if(binding >= 0)
            {
                break;
            }
            numScopesBack++;
            next = next.getPrevious();
        }
        return binding;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

    public ArrayList<Integer> getElementList() {
        return elementList;
    }

    public void setElementList(ArrayList<Integer> elementList) {
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

    public int getNumScopesBack() {
        return numScopesBack;
    }

    public void setNumScopesBack(int numScopesBack) {
        this.numScopesBack = numScopesBack;
    }

    public String toString()
    {
        String s = "";
        EFrame next = this;
        int i = 0;
        while(next != null)
        {
            for(String p: next.getElementNames())
            {
                s+= p + " ";
            }
            s+= ": " + i++ + "\n";
            next = next.getPrevious();
        }
        return s;
    }
}
