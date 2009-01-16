package expression;

import value.ClosureValue;
import value.IdValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import test.Testable;

public class OpAssign implements Expression{
	
	private Expression left;
	private Expression right;

    @Testable
    public OpAssign(Expression left, Expression right)
	{
		this.left = left;
		this.right = right;
	}
    @Testable
	@Override
	public Environment getValue(Environment environment) throws ReturnException {
		// the returned value for the left should be an ID
		Environment newEnv = left.getValue(environment);
		Value leftVal = left.getValue(environment).value;
		
		// pop top off
		newEnv = newEnv.next;
		
		// if type isn't ID then error
		if (!(leftVal instanceof IdValue))
		{
			// TODO:: Return an exception
		}
		
		String name = ((IdValue)leftVal).getInternalValue();
		Environment environ = Environment.findIDInList(name, newEnv);
		if (environ != null)
		{
			// mutate the value and return
			newEnv = right.getValue(newEnv);
			environ.value = newEnv.value;
			
			// check to see if its a closure
			if (environ.value instanceof ClosureValue)
			{
				((ClosureValue)environ.value).setEnvironment(newEnv.next);
			}
			
			// return a reference to what we assigned...
			return new Environment(newEnv.next, name, new IdValue(name));
		}
		else
		{
			// TODO: Add exception
		}
		
		
		return null;
	}

}
