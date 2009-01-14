package expression;

import value.IdValue;
import value.Value;
import Interpreter.Environment;

public class OpAssign implements Expression{
	
	private IdValue left;
	private Expression right;
	
	public OpAssign(IdValue left, Expression right)
	{
		this.left = left;
		this.right = right;
	}

	@Override
	public Value getValue(Environment environment) {
		String name = left.getInternalValue();
		Environment environ = Environment.findIDInList(name, environment);
		if (environ != null)
		{
			environ.value = right.getValue(environment);
			return environ.value;
		}
		else
		{
			// error
		}
		
		
		return null;
	}

}
