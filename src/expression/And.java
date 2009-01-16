package expression;

import value.BoolValue;
import value.FloatValue;
import value.IdValue;
import value.IntValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;

public class And implements Expression {
	
	private Expression one;
	private Expression two;
	
	public And(Expression one, Expression two)
	{
		this.one = one;
		this.two = two;
	}

	@Override
	public Environment getValue(Environment environment) throws ReturnException {
		Environment nEnv = one.getValue(environment);
		Value leftSide = nEnv.value;
		nEnv = nEnv.next;
		
		nEnv = two.getValue(nEnv);
		Value rightSide = nEnv.value;
		nEnv = nEnv.next;
		
		// check to see if one of them is an ID
		if (leftSide instanceof IdValue)
		{
			String name = ((IdValue)leftSide).getInternalValue();
			Environment environ = Environment.findIDInList(name, nEnv);
			// check for null
			if (environ != null)
			{
				leftSide = environ.value;
			}
			else
			{
				// TODO: Exception, type not found
			}
		}
		if (rightSide instanceof IdValue)
		{
			String name = ((IdValue)rightSide).getInternalValue();
			Environment environ = Environment.findIDInList(name, nEnv);
			// check for null
			if (environ != null)
			{
				rightSide = environ.value;
			}
			else
			{
				// TODO: Exception, type not found
			}
		}
		
		// now check to make sure both are bool types
		if (!(leftSide instanceof BoolValue) 
			|| !(rightSide instanceof BoolValue))
		{
			// TODO: throw an exception here
		}
		
		boolean ls = ((BoolValue)leftSide).getInternalValue();
		boolean rs = ((BoolValue)rightSide).getInternalValue();
			
		return new Environment(environment, null, new BoolValue(ls && rs));
	}

}
