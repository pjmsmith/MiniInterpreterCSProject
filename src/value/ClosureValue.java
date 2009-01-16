package value;

import java.util.List;

import expression.Sequence;

import Interpreter.Environment;
import Interpreter.ReturnException;

public class ClosureValue implements Value{
	
	private Environment environ;
	private Function func;
	
	public ClosureValue(Function func)
	{
		environ = null;
		this.func = func;
	}
	
	
	public void setEnvironment(Environment env)
	{
		environ = env;
	}
	
	@Override
	public boolean isType(Value val) {
		return val instanceof ClosureValue;
	}

	@Override
	public Environment getValue(Environment environment) throws ReturnException {

		
		return null;
	}

}
