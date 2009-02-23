package staticpass;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import expression.Expression;

public class Scope implements Expression {
	
	private Expression expression;
	
	public Scope(Expression exp)
	{
		expression = exp;
	}
	
	public Expression getExpression()
	{
		return expression;
	}

	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
        return expression.getValue(environment);
	}

    public String toString()
    {
        return "[Scope " + expression + "]";
    }

}
