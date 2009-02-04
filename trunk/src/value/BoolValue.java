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
	public Environment getValue(Environment environment) {
		return new Environment(environment, null, this);
	}

    @Testable
	public boolean isType(Value val) {
		return val instanceof BoolValue;
	}

}
