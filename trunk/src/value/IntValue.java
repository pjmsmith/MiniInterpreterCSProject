package value;

import Interpreter.Environment;

public class IntValue implements Value {

	private int value;
	
	public IntValue()
	{
		value = 0;
	}
	
	public IntValue(int val)
	{
		value = val;
	}
	
	public int getInternalValue()
	{
		return value;
	}
	
	@Override
	public boolean isType(Value val) {
		return val instanceof IntValue;
	}
	
	@Override
	public Environment getValue(Environment environment) {
		// TODO Auto-generated method stub
		return new Environment(environment, null, this);
	}
	
}
