package value;

import Interpreter.Environment;

public class FloatValue implements Value {
	
	private float value;
	
	public FloatValue()
	{
		value = 0;
	}
	
	public FloatValue(float val)
	{
		value = val;
	}
	
	public float getInternalValue()
	{
		return value;
	}
	
	@Override
	public boolean isType(Value val) {
		return val instanceof FloatValue;
	}

	@Override
	public Value getValue(Environment environment) {
		// TODO Auto-generated method stub
		return this;
	}

}
