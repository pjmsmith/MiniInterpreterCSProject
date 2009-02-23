package expression;

import value.IntValue;
import value.StringValue;
import value.Value;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class SubString implements Expression {
	
	private Expression string;
	private Expression start;
	private Expression end;

    @Testable
    public SubString(Expression string, Expression start, Expression end)
	{
		this.string = string;
		this.start = start;
		this.end = end;
	}

    @Testable
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException, UnboundIdentifierException {
		
		Environment nEnv = string.getValue(environment);
		Value val = nEnv.value;
		nEnv = nEnv.next;
		
		// check for an ID
		val = Environment.checkForID(val, nEnv);
		
		// check to see if its a string or an ID
		if (!(val instanceof StringValue))
		{
			throw new TypeException();
		}
		
		// now get the first number
		nEnv = start.getValue(nEnv);
		Value firstNum = nEnv.value;
		nEnv = nEnv.next;
		firstNum = Environment.checkForID(firstNum, nEnv);
		
		// now get the Second number
		nEnv = start.getValue(nEnv);
		Value secNum = nEnv.value;
		nEnv = nEnv.next;
		firstNum = Environment.checkForID(secNum, nEnv);
		
		// make sure they are both ints
		if (firstNum instanceof IntValue && secNum instanceof IntValue)
		{
			String string = ((StringValue)val).getInternalValue();
			int beginIndex = ((IntValue)firstNum).getInternalValue();
			int endIndex = ((IntValue)secNum).getInternalValue();
			
			return new Environment(nEnv, null, 
					new StringValue(string.substring(beginIndex, endIndex)));
		}
		else
		{
			throw new TypeException();
		}
	}

    public String toString()
    {
        return "(SubString (target " + string + ") (startIdx " + start + ") (endIdx " + end + "))";
    }
}
