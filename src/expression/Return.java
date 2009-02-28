package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class Return implements Expression {
	
	private Expression exp;

    @Testable
    public Return(Expression exp)
	{
		this.exp = exp;
	}

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    @Testable
	public Environment getValue(Environment environment) throws ReturnException, TypeException, UnboundIdentifierException {
		
		// throw a new expression with the value returned
		throw new ReturnException(exp.getValue(environment).value);
	}

    public String toString()
    {
        return "(Return " + exp + ")";
    }

}
