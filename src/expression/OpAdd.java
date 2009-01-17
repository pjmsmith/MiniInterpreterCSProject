package expression;

import value.*;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import test.Testable;

public class OpAdd implements Expression {
	
	private Expression one;
	private Expression two;

    @Testable
    public OpAdd()
	{
		
	}
	@Testable
	public OpAdd(Expression one, Expression two)
	{
		this.one = one;
		this.two = two;
	}
    @Testable
	@Override
	public Environment getValue(Environment environment) throws ReturnException, TypeException {
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

		// now do the op
		if (leftSide instanceof FloatValue || rightSide instanceof FloatValue)
		{
			float ls = 0;
			float rs = 0;
			
			// pull left side as a float
			if (leftSide instanceof FloatValue)
			{
				ls = ((FloatValue)leftSide).getInternalValue();
			}
			else if(leftSide instanceof IntValue)
			{
				ls = (float)((IntValue)leftSide).getInternalValue();
			}
			
			// pull right side as a float
			if (rightSide instanceof FloatValue)
			{
				rs = ((FloatValue)rightSide).getInternalValue();
			}
			else if(rightSide instanceof IntValue)
			{
				rs = (float)((IntValue)rightSide).getInternalValue();
			}
			
			return new Environment(environment, null, new FloatValue(ls + rs));
		}
		else if (leftSide instanceof IntValue && rightSide instanceof IntValue)
		{
			int ls = ((IntValue)leftSide).getInternalValue();
			int rs = ((IntValue)rightSide).getInternalValue();
			
			return new Environment(environment, null, new IntValue(ls + rs));
		}
		else
        {
            throw new TypeException();
        }
	}

}
