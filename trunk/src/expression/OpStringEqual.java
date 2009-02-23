package expression;

import value.BoolValue;
import value.StringValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class OpStringEqual implements Expression {
	
	private Expression left;
	private Expression right;

    @Testable
    public OpStringEqual(Expression left, Expression right)
	{
		this.left = left;
		this.right = right;
	}

    @Testable
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
		
		return new Environment(nEnv, null, new BoolValue(one.equals(two)));
	}

    public String toString()
    {
        return "(OpStringEqual " + left + " " + right + ")";
    }

}
