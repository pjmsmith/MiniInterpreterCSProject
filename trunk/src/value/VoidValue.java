package value;

import Interpreter.Environment;
import test.Testable;

public class VoidValue implements Value {

    @Testable
    public VoidValue()
	{
		
	}

    @Testable
    @Override
	public boolean isType(Value val) {
		return val instanceof VoidValue;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) {
		return new Environment(environment, null, this);
	}

}
