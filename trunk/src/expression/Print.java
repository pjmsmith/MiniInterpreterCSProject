package expression;

import value.*;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class Print implements Expression {
	
	private Expression value;

    @Testable
    public Print(Expression one)
	{
		value = one;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) throws ReturnException, 
		TypeException, UnboundIdentifierException {
		// print the value and return a new void pushed on top
		Environment nEnv = value.getValue(environment);
		Value printVal = nEnv.value;
		nEnv = nEnv.next;
		
		// check for ID
		if (printVal instanceof IdValue)
		{
			String name = ((IdValue)printVal).getInternalValue();
			Environment environ = Environment.findIDInList(name, nEnv);
			// check for null
			if (environ != null)
			{
				printVal = environ.value;
			}
			else
			{
				// TODO: Exception, type not found
			}
		}
		
		// check check for type and print
		if (printVal instanceof IntValue)
		{
			System.out.println(((IntValue)printVal).getInternalValue());
		}
		else if (printVal instanceof FloatValue)
		{
			System.out.println(((FloatValue)printVal).getInternalValue());
		}
		else if (printVal instanceof StringValue)
		{
			System.out.println(((StringValue)printVal).getInternalValue());
		}
		else if (printVal instanceof BoolValue)
		{
			System.out.println(((BoolValue)printVal).getInternalValue());
		}
		
		
		// return
		return new Environment(nEnv, null, new VoidValue());
	}

}
