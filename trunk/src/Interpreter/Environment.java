package Interpreter;
import value.Value;


public class Environment {
	public Environment next;
	public String id;
	public Value value;
	
	public Environment(Environment next, String name, Value val)
	{
		this.next = next;
		id = name;
		value = val;
	}
	
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
}
