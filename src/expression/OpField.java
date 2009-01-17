package expression;

import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import value.Object;

public class OpField implements Expression {
	
	private Expression object;
	private String name;
	private Expression assign;
	
	public OpField(Expression obj, String name, Expression assign)
	{
		object = obj;
		this.name = name;
		this.assign = assign;
	}

	@Override
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		
		Environment newEnv = object.getValue(environment);
		Value obj = newEnv.value;
		
		//check to make sure its an object
		if (obj instanceof value.Object)
		{
			value.Object refObject = (value.Object)obj;
			// check to see if this is a ref, or a mutate
			if (assign == null)
			{
				// ref, return value
				Environment env = refObject.getField(name);
				if (env != null)
				{
					// hope it works?
					return env;
				}
				else
				{
					throw new TypeException();
				}
			}
			else
			{
				// mutate
				newEnv = assign.getValue(newEnv);
				Environment env = refObject.getField(name);
				if (env != null)
				{
					env.value = newEnv.value;
					return new Environment(newEnv.next, null, newEnv.value);
				}
				else
				{
					throw new TypeException();
				}
			}
		}
		else
		{
			throw new TypeException();
		}
	}

}