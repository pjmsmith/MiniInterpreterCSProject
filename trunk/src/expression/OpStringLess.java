package expression;

import value.BoolValue;
import value.StringValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;

public class OpStringLess implements Expression {
	
	private Expression left;
	private Expression right;
	
	public OpStringLess(Expression left, Expression right)
	{
		this.left = left;
		this.right = right;
	}

	@Override
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		Environment nEnv = left.getValue(environment);
		Value leftVal = nEnv.value;
		nEnv = nEnv.next;
		nEnv = right.getValue(nEnv);
		Value rightVal = nEnv.value;
		nEnv = nEnv.next;
		
		leftVal = Environment.checkForID(leftVal, nEnv);
		rightVal = Environment.checkForID(rightVal, nEnv);
		
		// check to make sure they are strings
		if (!(leftVal instanceof StringValue) 
			|| !(rightVal instanceof StringValue))
		{
			throw new TypeException();
		}
		
		String one = ((StringValue)leftVal).getInternalValue();
		String two = ((StringValue)rightVal).getInternalValue();
		
		// check using for loop
		for (int i=0; i < one.length(); i++)
		{
			// this isn't right /cry
			if (one.charAt(i) < two.charAt(i))
			{
				
			}
			else
			{
				return new Environment(nEnv, null, new BoolValue(false));
			}
		}
		
		// If we get here the first was less tha the second
		return new Environment(nEnv, null, new BoolValue(true));
	}

}
