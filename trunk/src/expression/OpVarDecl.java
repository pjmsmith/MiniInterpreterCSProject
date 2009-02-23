package expression;

import value.IdValue;
import value.VoidValue;
import Interpreter.Environment;
import test.Testable;

public class OpVarDecl implements Expression {
	
	private String name;
	private int framecnt;
	private int framenum;

    @Testable
    public OpVarDecl(String name)
	{
		this.name = name;
		framecnt = 0;
		framenum = 0;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrameCnt(int cnt) {
    	framecnt = cnt;
    }
    
    public void setFrameNum(int num) {
    	framenum = num;
    }
    
    public int getFrameCnt() {
    	return framecnt;
    }
    
    public int getFrameNum() {
    	return framenum;
    }

    @Testable
	public Environment getValue(Environment environment) {
		// Add the new environment, and then a reference to the value
		Environment newEnv = new Environment(environment, name, new VoidValue());
		
		// now add the dummy ID ref
		IdValue temp = new IdValue(name);
		
		// now push the id ref on front and return
		return new Environment(newEnv, null, temp);
	}

    public String toString()
    {
        return "(OpVarDecl " + name + ")";
    }
}
