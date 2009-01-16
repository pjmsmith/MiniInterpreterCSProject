package expression;

import java.util.List;

import value.Value;
import value.VoidValue;
import Interpreter.Environment;
import Interpreter.ReturnException;
import test.Testable;

public class Sequence implements Expression {
	
	private List<Expression> expressions;

    @Testable
    public Sequence(List<Expression> expr)
	{
		expressions = expr;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) throws ReturnException  {
		Environment tempEnv = environment;
		for (int i=0; i < expressions.size(); i++)
		{
			tempEnv = expressions.get(i).getValue(tempEnv);
			// pop top off
			tempEnv = tempEnv.next;
		}

		return new Environment(tempEnv, null, new VoidValue());
	}

}
