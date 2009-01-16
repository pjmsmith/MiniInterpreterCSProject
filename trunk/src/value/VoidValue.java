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
	public Environment getValue(Environment environment) {
		// TODO Auto-generated method stub
		return new Environment(environment, null, this);
	}

}
