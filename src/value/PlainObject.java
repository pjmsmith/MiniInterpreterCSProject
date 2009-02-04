package value;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class PlainObject extends Object {

    @Testable
    public PlainObject()
	{
		
	}

    @Testable
	public boolean isType(Value val) {
		return val instanceof PlainObject;
	}

    @Testable
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		return new Environment(environment, null, this);
	}

    public String toString()
    {
        return "(PlainObject " + super.toString() + ")";
    }
}
