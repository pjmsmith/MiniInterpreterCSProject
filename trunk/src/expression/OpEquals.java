package expression;

import value.BoolValue;
import value.IntValue;
import value.StringValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class OpEquals implements Expression {

	private Expression left;
	private Expression right;

    @Testable
    public OpEquals(Expression one, Expression two)
	{
		left = one;
		right = two;
	}

    @Testable
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		
		Environment nEnv = left.getValue(environment);
		Value leftVal = nEnv.value;
		nEnv = nEnv.next;
		
		nEnv = right.getValue(environment);
		Value rightVal = nEnv.value;
		nEnv = nEnv.next;
		
		leftVal = Environment.checkForID(leftVal, nEnv);
		rightVal = Environment.checkForID(rightVal, nEnv);
		
		// check to make sure its not a string
		if (leftVal instanceof StringValue)
		{
			return new Environment(nEnv, null, new BoolValue(false));
		}
		
		// check to make sure the values are the same type
		if (leftVal.isType(rightVal))
		{
			boolean val = false;
			// check for int
			if (leftVal instanceof IntValue)
			{
				int one = ((IntValue)leftVal).getInternalValue();
				int two = ((IntValue)rightVal).getInternalValue();
				val = (one == two);
			}
			return new Environment(nEnv, null, new BoolValue(val));
		}
		else
		{
			return new Environment(nEnv, null, new BoolValue(false));
		}
		
	}

}
