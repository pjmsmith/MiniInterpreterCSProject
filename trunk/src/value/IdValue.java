package value;

import Interpreter.Environment;

public class IdValue implements Value {
	
	private String value;
	
	public IdValue()
	{
		value = "";
	}
	
	public IdValue(String val)
	{
		value = val;
	}
	
	public String getInternalValue()
	{
		return value;
	}

	@Override
	public Value getValue(Environment environment) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean isType(Value val) {
		return val instanceof IdValue;
	}

}
