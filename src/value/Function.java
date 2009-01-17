package value;

import java.util.List;

import expression.Sequence;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class Function implements Value{
	private List<String> params;
	private Sequence sequence;

    @Testable
    public Function(List<String> params, Sequence seq)
	{
		this.params = params;
		sequence = seq;
	}

    @Testable
    public List<String> getParamList()
	{
		return params;
	}
	
    @Testable
	@Override
	public boolean isType(Value val) {
		return val instanceof Function;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) throws ReturnException, TypeException, UnboundIdentifierException  {
		Environment newEnv = null;
		// run the function
		try
		{
			newEnv = sequence.getValue(environment);
		}
		catch (ReturnException e)
		{
			return new Environment(environment, null, e.getRetVal());
		}

		return new Environment(newEnv, null, new VoidValue());
	}

}
