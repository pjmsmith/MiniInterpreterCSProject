package value;

import Interpreter.Environment;

public class ClosureValue implements Value{
	
	@Override
	public boolean isType(Value val) {
		return val instanceof ClosureValue;
	}

	@Override
	public Value getValue(Environment environment) {
		// TODO Auto-generated method stub
		return null;
	}

}
