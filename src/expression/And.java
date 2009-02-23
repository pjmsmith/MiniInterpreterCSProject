package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;
import value.BoolValue;
import value.IdValue;
import value.Value;

public class And implements Expression {
	
	private Expression one;
	private Expression two;

    @Testable
    public And(Expression one, Expression two)
	{
		this.one = one;
		this.two = two;
	}

    public Expression getOne() {
        return one;
    }

    public Expression getTwo() {
        return two;
    }

    @Testable
	public Environment getValue(Environment environment) throws ReturnException, TypeException, UnboundIdentifierException {
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
				throw new UnboundIdentifierException();
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
				throw new UnboundIdentifierException();
			}
		}
		
		// now check to make sure both are bool types
		if (!(leftSide instanceof BoolValue) 
			|| !(rightSide instanceof BoolValue))
		{
			throw new TypeException();
		}
		
		boolean ls = ((BoolValue)leftSide).getInternalValue();
		boolean rs = ((BoolValue)rightSide).getInternalValue();
			
		return new Environment(environment, null, new BoolValue(ls && rs));
	}

    public String toString()
    {
        return "(And " + one + " " + two + ")";
    }
}
