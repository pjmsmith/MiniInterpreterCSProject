package value;

import Interpreter.Environment;

import java.util.LinkedList;
import java.util.List;

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
    	// check to see if the field exists, if it doesn't add it
    	if (!doesFieldExist(name))
    		addField(name, new VoidValue());
    	
        for (Environment field : fields) {
            if (field.id.compareTo(name) == 0) {
                return field;
            }
        }
		
		return null;
	}

    public String toString()
    {
        String s =  "(Object (fields ";
        if(fields.isEmpty())
        {
            s += " (fields (Empty))";
        }
        else
        {
            String fieldsStr =  " (fields ";
            for(Environment f:fields)
            {
                fieldsStr += f + " ";
            }
            fieldsStr = fieldsStr.substring(0, (fieldsStr.length()-1));
            s += fieldsStr + "))";
        }
        for(Environment e: fields)
        {
            s += e.toString() + " ";
        }
        s += ")";
        return s;
    }
}
