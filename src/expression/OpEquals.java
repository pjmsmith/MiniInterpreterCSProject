package expression;

import value.BoolValue;
import value.StringValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;

public class OpEquals implements Expression {

	private Expression left;
	private Expression right;
	
	public OpEquals(Expression one, Expression two)
	{
		left = one;
		right = two;
	}
	
	@Override
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		
		Environment nEnv = left.getValue(environment);
		Value leftVal = nEnv.value;
		nEnv = nEnv.next;
		
		nEnv = left.getValue(environment);
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
		return new Environment(nEnv, null, new BoolValue(leftVal.isType(rightVal)));
	}

}
