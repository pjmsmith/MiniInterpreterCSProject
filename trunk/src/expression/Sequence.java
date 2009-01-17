package expression;

import java.util.List;

import value.Value;
import value.VoidValue;
import value.IntValue;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.UnboundIdentifierException;
import Interpreter.TypeException;
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
	public Environment getValue(Environment environment) throws ReturnException, UnboundIdentifierException, TypeException {
		Environment tempEnv = new Environment(environment, null, new VoidValue());
        if(expressions.isEmpty())
        {
            return tempEnv;
        }
        else
        {
            tempEnv = environment;
            Environment ansEnv = null;
            Environment t = null;
            for (Expression expression : expressions) {
                ansEnv = expression.getValue(tempEnv);
                tempEnv = ansEnv;
                //TODO: re-test sequences
            }

            return tempEnv;
        }
    }

}
