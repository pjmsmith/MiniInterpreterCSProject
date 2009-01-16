package value;

import Interpreter.Environment;
import expression.Expression;

public class BoolValue implements Value {
	private boolean value;
	
	public BoolValue(boolean val)
	{
		value = val;
	}
	
	public boolean getInternalValue()
	{
		return value;
	}

	@Override
	public Environment getValue(Environment environment) {
		// TODO Auto-generated method stub
		return new Environment(environment, null, this);
	}

	@Override
	public boolean isType(Value val) {
		// TODO Auto-generated method stub
		return val instanceof BoolValue;
	}

}
