package expression;

import value.BoolValue;
import value.Value;
import value.IdValue;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class IsType implements Expression {
	
	private Class<? extends Value> type;
	private Expression value;

    @Testable
    public IsType(Class<? extends Value> type, Expression exp)
	{
		this.type = type;
		this.value = exp;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		if(value instanceof IdValue)
        {
            String name = ((IdValue)value).getInternalValue();
			Environment environ = Environment.findIDInList(name, environment);
			// check for null
			if (environ != null)
			{
				value = environ.value;
			}
			else
			{
				throw new UnboundIdentifierException();
			}
        }
        Environment nEnv = value.getValue(environment);
		Value val = nEnv.value;
		nEnv = nEnv.next;

		return new Environment(nEnv, null, new BoolValue(val.getClass() == type));
	}

}
