package value;

import Interpreter.Environment;

public class StringValue implements Value {

	private String value;
	
	public StringValue()
	{
		value = "";
	}
	
	public StringValue(String val)
	{
		value = val;
	}
	
	public String getInternalValue()
	{
		return value;
	}
	
	@Override
	public boolean isType(Value val) {
		return val instanceof StringValue;
	}

	@Override
	public Value getValue(Environment environment) {
		// TODO Auto-generated method stub
		return this;
	}
}
