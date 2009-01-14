package expression;

import java.util.List;

import value.Value;
import Interpreter.Environment;

public class Sequence implements Expression {
	
	private List<Expression> expressions;
	
	public Sequence(List<Expression> expr)
	{
		expressions = expr;
	}

	@Override
	public Value getValue(Environment environment) {

		for (int i=0; i < expressions.size(); i++)
		{
			expressions.get(i).getValue(environment);
		}

		return null;
	}

}
