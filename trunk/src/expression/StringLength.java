package expression;

import value.IntValue;
import value.StringValue;
import Interpreter.Environment;
import Interpreter.ReturnException;
import test.Testable;

public class StringLength implements Expression {
	
	private Expression string;

    @Testable
    public StringLength(Expression exp)
	{
		string = exp;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) throws ReturnException {
		
		Environment nEnv = string.getValue(environment);
		
		// check to see if its a string type
		if (nEnv != null && nEnv.value instanceof StringValue)
		{
			String str = ((StringValue)nEnv.value).getInternalValue();
			return new Environment(nEnv.next, null, new IntValue(str.length()));
		}
		else
		{
			// TODO: Add exception
		}
		return null;
	}

}
