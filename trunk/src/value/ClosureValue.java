package value;

import java.util.List;

import expression.Sequence;

import Interpreter.Environment;
import Interpreter.ReturnException;
import test.Testable;

public class ClosureValue extends Object {
	
	private Environment environ;
	private Function func;

    @Testable
    public ClosureValue(Function func)
	{
		environ = null;
		this.func = func;
	}
	
	@Testable
	public void setEnvironment(Environment env)
	{
		environ = env;
	}

    @Testable
    public Environment getEnvironment()
	{
		return environ;
	}

    @Testable
    public Function getIntFunc()
	{
		return func;
	}

    @Testable
	public boolean isType(Value val) {
		return val instanceof ClosureValue;
	}

    @Testable
	public Environment getValue(Environment environment) throws ReturnException {
		return new Environment(environment, null, this);
	}

}
