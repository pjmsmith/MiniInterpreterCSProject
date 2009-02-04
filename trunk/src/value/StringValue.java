package value;

import Interpreter.Environment;
import test.Testable;

public class StringValue extends Object {

	private String value;

    @Testable
    public StringValue()
	{
		value = "";
	}

    @Testable
    public StringValue(String val)
	{
    	// remove the " from the val if they are there on the edges
    	if (val.charAt(0) == '\"' && val.charAt(val.length() - 1) == '\"')
    	{
    		value = val.substring(1, val.length() - 1);
    	}
    	else
    	{
    		value = val;
    	}
	}
	
	@Testable
    public String getInternalValue()
	{
		return value;
	}

    @Testable
	public boolean isType(Value val) {
		return val instanceof StringValue;
	}

    @Testable
	public Environment getValue(Environment environment) {
		return new Environment(environment, null, this);
	}
}
