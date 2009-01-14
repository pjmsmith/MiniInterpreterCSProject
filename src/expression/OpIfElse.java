package expression;

import value.Value;
import Interpreter.Environment;

public class OpIfElse implements Expression {
	
	private Expression test;
	private Sequence first;  // if clause
	private Sequence second; // else clause
	
	public OpIfElse(Expression test, Sequence first, Sequence sec)
	{
		this.test = test;
		this.first = first;
		this.second = sec;
	}

	@Override
	public Value getValue(Environment environment) {
		// TODO Auto-generated method stub
		return null;
	}

}
