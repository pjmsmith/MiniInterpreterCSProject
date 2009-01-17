package value;

import java.util.LinkedList;
import java.util.List;

import Interpreter.Environment;

import expression.Expression;

public abstract class Object implements Value {
	
	private List<Environment> fields = new LinkedList<Environment>();
	
	public void addField(String name, Value val)
	{
		if (doesFieldExist(name))
		{
			for (int i=0; i < fields.size(); i++)
			{
				if (fields.get(i).id.compareTo(name) == 0)
				{
					fields.get(i).value = val;
				}
			}
		} 
		else
		{
			fields.add(new Environment(null, name, val));
		}
	}
	
	public boolean doesFieldExist(String name)
	{
		for (int i=0; i < fields.size(); i++)
		{
			if (fields.get(i).id.compareTo(name) == 0)
			{
				return true;
			}
		}
		// didn't find it
		return false;
	}
	
	public Environment getField(String name)
	{
		for (int i=0; i < fields.size(); i++)
		{
			if (fields.get(i).id.compareTo(name) == 0)
			{
				return fields.get(i);
			}
		}
		
		return null;
	}
}
