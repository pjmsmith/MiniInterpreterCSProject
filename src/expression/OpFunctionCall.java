package expression;

import java.util.List;

import value.IdValue;
import value.Value;
import Interpreter.Environment;

public class OpFunctionCall implements Expression {
	
	public OpFunctionCall(IdValue name, List<Expression> args)
	{
		
	}

	@Override
	public Value getValue(Environment environment) {
		// TODO Auto-generated method stub
		return null;
	}

}
