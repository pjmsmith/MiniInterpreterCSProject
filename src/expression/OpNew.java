package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;
import value.*;

import java.util.List;

public class OpNew implements Expression {
	
	private List<Expression> args;
	private IdValue fnc;

    @Testable
    public OpNew(IdValue func, List<Expression> args)
	{
		this.fnc = func;
		this.args = args;
	}

    @Testable
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		
    	Environment env = Environment.findIDInList(fnc.getInternalValue(), environment);
    	Value funcval = env.value;

    	// check to see if it is a function
		if (!(funcval instanceof Function))
		{
			throw new TypeException();
		}
		
		
		
		// Add args to environment
		Environment nEnv = environment;
		List<String> argNames = ((Function)funcval).getParamList();
		for (int i = 0; i < args.size(); i++)
		{
			nEnv = args.get(i).getValue(nEnv);
			Value temp = nEnv.value;
			nEnv = nEnv.next;
			nEnv = new Environment(nEnv, argNames.get(i), temp);
		}
		
		// now call the function
		nEnv = ((Function)funcval).getValue(nEnv);
		Value val = nEnv.value;
		nEnv = environment;
		
		// check to see if its a closure
		if (!(val instanceof ClosureValue))
		{
			throw new TypeException();
		}
		
		
		PlainObject obj = new PlainObject();
		obj.addField("constructor", val);
		
		// call closure
		nEnv = ((ClosureValue)val).getEnvironment();
		nEnv = new Environment(nEnv, "this", obj);
		//nEnv = val.getValue(nEnv);
		nEnv = ((ClosureValue)val).getIntFunc().getValue(nEnv);
		
		return new Environment(environment, null, obj);
	}

    public String toString()
    {
        String s = "(OpNew " + fnc.toString() + " args: ";
        for(Expression a:args)
        {
            s += a.toString() + " ";
        }
        s += ")";
        return s;
    }

}
