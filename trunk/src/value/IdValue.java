package value;

import Interpreter.Environment;
import test.Testable;

public class IdValue implements Value {
	
	private String value;

    @Testable
    public IdValue()
	{
		value = "";
	}

    @Testable
    public IdValue(String val)
	{
		value = val;
	}

    @Testable
    public String getInternalValue()
	{
		return value;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) {
		return new Environment(environment, value, this);
	}

    @Testable
    @Override
	public boolean isType(Value val) {
		return val instanceof IdValue;
	}

}
