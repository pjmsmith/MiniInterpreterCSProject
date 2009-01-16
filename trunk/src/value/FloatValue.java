package value;

import Interpreter.Environment;
import test.Testable;

public class FloatValue implements Value {
	
	private float value;

    @Testable
    public FloatValue()
	{
		value = 0;
	}

    @Testable
    public FloatValue(float val)
	{
		value = val;
	}

    @Testable
    public float getInternalValue()
	{
		return value;
	}

    @Testable
    @Override
	public boolean isType(Value val) {
		return val instanceof FloatValue;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) {
		// TODO Auto-generated method stub
		return new Environment(environment, null, this);
	}

}
