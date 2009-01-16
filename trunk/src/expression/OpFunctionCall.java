package expression;

import java.util.List;

import value.Function;
import value.IdValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;

public class OpFunctionCall implements Expression {
	
	private IdValue name;
	private List<Expression> args;
	
	public OpFunctionCall(IdValue name, List<Expression> args)
	{
		this.name = name;
		this.args = args;
	}

	@Override
	public Environment getValue(Environment environment) throws ReturnException {
		// Get Function
		Environment func = Environment.findIDInList(name.getInternalValue(), 
				environment);
		// check for null
		if (func == null)
		{
			// TODO: add exception
		}
		// check to make sure its a function
		if (!(func.value instanceof Function))
		{
			// TODO: add an exception
		}
		Function function = (Function)func.value;
		// Add args to environment
		Environment nEnv = environment;
		List<String> argNames = function.getParamList();
		for (int i = 0; i < args.size(); i++)
		{
			nEnv = args.get(i).getValue(nEnv);
			Value temp = nEnv.value;
			nEnv = nEnv.next;
			nEnv = new Environment(nEnv, argNames.get(i), temp);
		}
		
		// now call the function
		nEnv = function.getValue(nEnv);
		
		/// pull off the return type
		return new Environment(environment, null, nEnv.value);
	}

}
