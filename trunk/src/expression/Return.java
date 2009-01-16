package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;

public class Return implements Expression {
	
	private Expression exp;
	
	public Return(Expression exp)
	{
		this.exp = exp;
	}

	@Override
	public Environment getValue(Environment environment) throws ReturnException {
		
		// throw a new expression with the value returned
		throw new ReturnException(exp.getValue(environment).value);
	}

}
