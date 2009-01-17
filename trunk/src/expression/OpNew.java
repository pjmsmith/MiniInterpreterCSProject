package expression;

import java.util.List;

import value.ClosureValue;
import value.Function;
import value.PlainObject;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;

public class OpNew implements Expression {
	
	private List<Expression> args;
	private Function func;
	
	public OpNew(Function func, List<Expression> args)
	{
		this.func = func;
		this.args = args;
	}

	@Override
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		
		// Add args to environment
		Environment nEnv = environment;
		List<String> argNames = func.getParamList();
		for (int i = 0; i < args.size(); i++)
		{
			nEnv = args.get(i).getValue(nEnv);
			Value temp = nEnv.value;
			nEnv = nEnv.next;
			nEnv = new Environment(nEnv, argNames.get(i), temp);
		}
		
		// now call the function
		nEnv = func.getValue(nEnv);
		Value val = nEnv.value;
		nEnv = environment;
		
		// check to see if its a closure
		if (!(val instanceof ClosureValue))
		{
			throw new TypeException();
		}
		
		PlainObject obj = new PlainObject();
		obj.addField("constructor", val);
		
		// call closure
		nEnv = ((ClosureValue)val).getEnvironment();
		nEnv = new Environment(nEnv, "this", obj);
		nEnv = val.getValue(nEnv);
		
		return new Environment(environment, null, obj);
	}

}
