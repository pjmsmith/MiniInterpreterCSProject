package value;

import Interpreter.Environment;
import test.Testable;

public class StringValue implements Value {

	private String value;

    @Testable
    public StringValue()
	{
		value = "";
	}

    @Testable
    public StringValue(String val)
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
	public boolean isType(Value val) {
		return val instanceof StringValue;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) {
		// TODO Auto-generated method stub
		return new Environment(environment, null, this);
	}
}
