package value;

import Interpreter.Environment;

public class VoidValue implements Value {
	
	public VoidValue()
	{
		
	}
	
	@Override
	public boolean isType(Value val) {
		return val instanceof VoidValue;
	}

	@Override
	public Value getValue(Environment environment) {
		// TODO Auto-generated method stub
		return this;
	}

}
