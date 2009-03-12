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
    private ArrayList<Integer> elementList;
    private ArrayList<String> elementNames;
    private EFrame previous;
    private int numScopesBack;

    public Closure(EFrame previous)
    {
        this.previous = previous;
        numElements = 0;
        elementList = new ArrayList<Integer>();
        elementNames = new ArrayList<String>();
        numScopesBack = 0;
    }


}
