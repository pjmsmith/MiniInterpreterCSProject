package expression;

import value.BoolValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class IsType implements Expression {
	
	private Class<Value> type;
	private Expression value;

    @Testable
    public IsType(Class<Value> type, Expression exp)
	{
		this.type = type;
		this.value = exp;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		
		Environment nEnv = value.getValue(environment);
		Value val = nEnv.value;
		nEnv = nEnv.next;

		return new Environment(nEnv, null, new BoolValue(val.getClass() == type));
	}

}
