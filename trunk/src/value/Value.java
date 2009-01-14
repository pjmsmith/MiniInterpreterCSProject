package value;

import expression.Expression;

public interface Value extends Expression {
	public boolean isType(Value val);
}
