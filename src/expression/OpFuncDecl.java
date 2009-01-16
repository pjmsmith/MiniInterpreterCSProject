package expression;

import value.Function;
import value.VoidValue;
import Interpreter.Environment;
import Interpreter.ReturnException;

public class OpFuncDecl implements Expression {
	
	private Function func;
	private String name;
	
	public OpFuncDecl(Function func, String name)
	{
		this.func = func;
		this.name = name;
	}

	@Override
	public Environment getValue(Environment environment) throws ReturnException {
		// add the function to the environment
		Environment nEnv = new Environment(environment, name, func);
		
		// add dummy val
		return new Environment(nEnv, null, new VoidValue());
	}

}
