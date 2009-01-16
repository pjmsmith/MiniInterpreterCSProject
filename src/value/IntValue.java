package value;

import Interpreter.Environment;
import test.Testable;

public class IntValue implements Value {

	private int value;

    @Testable
    public IntValue()
	{
		value = 0;
	}

    @Testable
    public IntValue(int val)
	{
		value = val;
	}

    @Testable
    public int getInternalValue()
	{
		return value;
	}

    @Testable
    @Override
	public boolean isType(Value val) {
		return val instanceof IntValue;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) {
		// TODO Auto-generated method stub
		return new Environment(environment, null, this);
	}
	
}
