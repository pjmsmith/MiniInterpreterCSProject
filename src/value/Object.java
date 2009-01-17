package value;

import java.util.LinkedList;
import java.util.List;

import Interpreter.Environment;

import expression.Expression;
import test.Testable;

public abstract class Object implements Value {
	
	private List<Environment> fields = new LinkedList<Environment>();

    public void addField(String name, Value val)
	{
		if (doesFieldExist(name))
		{
            for (Environment field : fields) {
                if (field.id.compareTo(name) == 0) {
                    field.value = val;
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
        for (Environment field : fields) {
            if (field.id.compareTo(name) == 0) {
                return true;
            }
        }
		// didn't find it
		return false;
	}

    public Environment getField(String name)
	{
        for (Environment field : fields) {
            if (field.id.compareTo(name) == 0) {
                return field;
            }
        }
		
		return null;
	}
}
