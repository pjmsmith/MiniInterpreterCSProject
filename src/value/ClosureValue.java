package value;

import Interpreter.Environment;
import Interpreter.ReturnException;
import test.Testable;

public class ClosureValue extends Object {
	
	private Environment environ;
	private Function func;
	private int funcId;

    @Testable
    public ClosureValue(Function func)
	{
		environ = null;
		this.func = func;
		funcId = 0;
	}
	
	@Testable
	public void setEnvironment(Environment env)
	{
		environ = env;
	}

    @Testable
    public Environment getEnvironment()
	{
		return environ;
	}

    @Testable
    public Function getIntFunc()
	{
		return func;
	}
    
    public int getFuncId() {
    	return funcId;
    }
    
    public void setFuncId(int val) {
    	funcId = val;
    }

    @Testable
	public boolean isType(Value val) {
		return val instanceof ClosureValue;
	}

    @Testable
	public Environment getValue(Environment environment) throws ReturnException {
		return new Environment(environment, null, this);
	}

    public String toString()
    {
        String s = "(Closure ";
        if(environ == null)
        {
            s += "(EmptyEnv) ";
        }
        else
        {
            s += environ + " ";
        }
        s += func + ")";
        return s;
    }
}
