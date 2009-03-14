package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;
import value.IdValue;
import value.Value;

public class OpField implements Expression {
	
	private Expression object;
	private String name;
	private Expression assign;
	private Expression left;
	private Expression right;

    @Testable
    public OpField(Expression obj, String name, Expression assign)
	{
		object = obj;
		this.name = name;
		this.assign = assign;
	}
    
    public OpField(Expression left, Expression right)
    {
    	this.left = left;
    	this.right = right;
    }

    @Testable
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
    	
    	Environment newEnv = left.getValue( environment);
		Value obj = newEnv.value;
		obj = Environment.checkForID(obj, newEnv.next);
		
		newEnv = right.getValue(environment);
		Value rightSide = newEnv.value;
		//rightSide = Environment.checkForID(rightSide, newEnv.next);
		
		if (obj instanceof value.Object && rightSide instanceof IdValue)
		{
			value.Object refObject= (value.Object)obj;
			Environment env = refObject.getField(((IdValue)rightSide).getInternalValue());
			if (env != null)
			{
				// hope it works?
				return new Environment(env, null, env.value);
			}
			else
			{
				throw new TypeException();
			}
		}
		else
		{
			throw new TypeException();
		}
		
		/*
		Environment newEnv = object.getValue(environment);
		Value obj = newEnv.value;
		
		obj = Environment.checkForID(obj, newEnv.next);
		
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
					return new Environment(env, null, env.value);
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
		*/
	}

    public String toString()
    {
        String s = "(OpField";
        if(assign==null)
        {
            s+= "Lookup" + object + "(FieldName " + name + "))";
        }
        else
        {
            s+= "Mutation" + object + "(FieldName " + name + ") (NewValue " + assign + "))";
        }
        return s;
    }

}
