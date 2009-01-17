package value;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;

public class PlainObject extends Object {
	
	public PlainObject()
	{
		
	}

	@Override
	public boolean isType(Value val) {
		// TODO Auto-generated method stub
		return val instanceof PlainObject;
	}

	@Override
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		// TODO Auto-generated method stub
		return new Environment(environment, null, this);
	}

}
