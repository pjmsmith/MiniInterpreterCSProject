package expression;

import value.BoolValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class OpInstanceOf implements Expression {
	
	private value.Object obj;
	private Value val;

    @Testable
    public OpInstanceOf(value.Object obj, Value val)
	{
		this.obj = obj;
		this.val = val;
	}

    @Testable
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		
		// check for an constructor
		if (obj.doesFieldExist("constructor") 
				&& val.equals(obj.getField("constructor").value))
		{
			// TRUE
			return new Environment(environment, null, new BoolValue(true));
		}
		// return false
		return new Environment(environment, null, new BoolValue(false));
	}

    public String toString()
    {
        return "(OpInstanceOf " + obj + " " + val + ")";
    }
}
