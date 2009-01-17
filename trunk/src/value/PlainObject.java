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
    @Override
	public boolean isType(Value val) {
		return val instanceof PlainObject;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		return new Environment(environment, null, this);
	}

}
