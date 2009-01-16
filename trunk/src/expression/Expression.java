package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import value.Value;

public interface Expression {
	public Environment getValue(Environment environment) throws ReturnException;
}
