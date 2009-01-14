package expression;

import Interpreter.Environment;
import value.Value;

public interface Expression {
	public Value getValue(Environment environment);
}
