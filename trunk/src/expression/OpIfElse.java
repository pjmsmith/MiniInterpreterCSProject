package expression;

import value.BoolValue;
import value.IdValue;
import value.Value;
import value.VoidValue;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class OpIfElse implements Expression {
	
	private Expression test;
	private Sequence first;  // if clause
	private Sequence second; // else clause

    @Testable
    public OpIfElse(Expression test, Sequence first, Sequence sec)
	{
		this.test = test;
		this.first = first;
		this.second = sec;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) throws ReturnException, 
		TypeException, UnboundIdentifierException {
    	
		// Test the expression to see if its true or false
		Environment tempEnv = test.getValue(environment);
		Value check = tempEnv.value;
		tempEnv = tempEnv.next;
		
		// check for ID
		if (check instanceof IdValue)
		{
			String name = ((IdValue)check).getInternalValue();
			Environment environ = Environment.findIDInList(name, tempEnv);
			// check for null
			if (environ != null)
			{
				check = environ.value;
			}
			else
			{
				throw new UnboundIdentifierException();
			}
		}
		
		// now do if check
		if (((BoolValue)check).getInternalValue())
		{
			tempEnv = first.getValue(tempEnv);
			tempEnv = tempEnv.next;
		}
		else
		{
			// if the second seq is a null, only and if check
			if (second != null)
			{
				tempEnv = second.getValue(tempEnv);
				tempEnv = tempEnv.next;
			}
		}
		
		return new Environment(tempEnv, null, new VoidValue());
	}

}
