package Interpreter;

import value.Value;

public class ReturnException extends Exception {

	private Value retVal;
	
	public ReturnException(Value ret)
	{
		retVal = ret;
	}
	
	public Value getRetVal()
	{
		return retVal;
	}
}
