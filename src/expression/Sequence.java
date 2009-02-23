package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;
import value.VoidValue;

import java.util.List;

public class Sequence implements Expression {
	
	private List<Expression> expressions;

    @Testable
    public Sequence(List<Expression> expr)
	{
		expressions = expr;
	}

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Testable
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
                tempEnv = ansEnv.next;
            }

            return new Environment(environment, null, new VoidValue());
        }
    }

    public String toString()
    {
        String s = "(Sequence ";
        for(Expression e:expressions)
        {
            s += "\n\t" + e;
        }
        s += ")";
        return s;
    }
}
