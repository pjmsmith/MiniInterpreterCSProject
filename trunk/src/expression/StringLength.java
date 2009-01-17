package expression;

import value.IdValue;
import value.IntValue;
import value.StringValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
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
	public Environment getValue(Environment environment) throws ReturnException, TypeException, UnboundIdentifierException {
		
		Environment nEnv = string.getValue(environment);
		Value val = nEnv.value;
		nEnv = nEnv.next;
		
		// check for an ID
		val = Environment.checkForID(val, environment);
		
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
