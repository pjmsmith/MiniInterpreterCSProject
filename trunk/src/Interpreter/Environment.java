package Interpreter;
import value.IdValue;
import value.Value;
import test.Testable;


public class Environment {
	public Environment next;
	public String id;
	public Value value;

    @Testable
    public Environment(Environment next, String name, Value val)
	{
		this.next = next;
		id = name;
		value = val;
	}

    @Testable
    public static Environment findIDInList(String name, Environment environment)
	{
		if (environment != null)
		{
			return environment.findID(name);
		}
		else
		{
			return null;
		}
	}

    @Testable
    public Environment findID(String name)
	{
		// check this value and then call down the chain
        if (id.compareTo(name) == 0)
		{
			return this;
		}
		else if (next != null)
		{
			return next.findID(name);
		}
		else
		{
			return null;
		}
	}
    
    @Testable
    public static Value checkForID(Value val, Environment env)
    {
    	// check for an ID
		if (val instanceof IdValue)
		{
			String name = ((IdValue)val).getInternalValue();
			Environment environ = Environment.findIDInList(name, env);
			// check for null
			if (environ != null)
			{
				return environ.value;
			}
			else
			{
				// TODO: Exception, type not found
			}
		}
		
		// return the default value
		return val;
    }
}
