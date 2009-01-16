package value;

import Interpreter.Environment;
import expression.Expression;
import test.Testable;

public class BoolValue implements Value {
	private boolean value;

    @Testable
    public BoolValue(boolean val)
	{
		value = val;
	}

    @Testable
    public boolean getInternalValue()
	{
		return value;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) {
		// TODO Auto-generated method stub
		return new Environment(environment, null, this);
	}

    @Testable
    @Override
	public boolean isType(Value val) {
		// TODO Auto-generated method stub
		return val instanceof BoolValue;
	}

}
