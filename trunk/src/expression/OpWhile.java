package expression;

import java.util.List;

import value.Value;
import Interpreter.Environment;

public class OpWhile implements Expression {
	
	private Expression check;
	private Sequence sequence;
	
	public OpWhile(Expression exp, Sequence seq)
	{
		check = exp;
		sequence = seq;
	}

	@Override
	public Value getValue(Environment environment) {
			
		sequence.getValue(environment);
		
		// shouldn't return a value?
		return null;
	}

}
