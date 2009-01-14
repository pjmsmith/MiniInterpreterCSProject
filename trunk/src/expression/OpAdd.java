package expression;

import value.*;
import Interpreter.Environment;

public class OpAdd implements Expression {
	
	private Expression left;
	private Expression right;
	
	public OpAdd()
	{
		
	}
	
	public OpAdd(Expression one, Expression two)
	{
		left = one;
		right = two;
	}

	@Override
	public Value getValue(Environment environment) {
		// if one value is a float, we must do it as a float
		Value leftSide = left.getValue(environment);
		Value rightSide = right.getValue(environment);
		
		if (leftSide instanceof FloatValue || rightSide instanceof FloatValue)
		{
			float ls = 0;
			float rs = 0;
			
			// pull left side as a float
			if (leftSide instanceof FloatValue)
			{
				ls = ((FloatValue)leftSide).getInternalValue();
			}
			else
			{
				ls = (float)((IntValue)leftSide).getInternalValue();
			}
			
			// pull right side as a float
			if (rightSide instanceof FloatValue)
			{
				ls = ((FloatValue)rightSide).getInternalValue();
			}
			else
			{
				ls = (float)((IntValue)rightSide).getInternalValue();
			}
			
			return new FloatValue(ls + rs);
		}
		else if (leftSide instanceof IntValue && rightSide instanceof IntValue)
		{
			int ls = ((IntValue)leftSide).getInternalValue();
			int rs = ((IntValue)rightSide).getInternalValue();
			
			return new IntValue(ls + rs);
		}
		else
		{
			// TODO:: Need to throw an error
		}
		
		return null;
	}

}
