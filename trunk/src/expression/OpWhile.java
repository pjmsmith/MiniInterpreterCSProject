package expression;

import java.util.List;

import value.BoolValue;
import value.IdValue;
import value.Value;
import value.VoidValue;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;

public class OpWhile implements Expression {
	
	private Expression test;
	private Sequence sequence;

    @Testable
    public OpWhile(Expression exp, Sequence seq)
	{
		test = exp;
		sequence = seq;
	}

    @Testable
	@Override
	public Environment getValue(Environment environment) throws ReturnException, 
		TypeException, UnboundIdentifierException  {
		
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
				// TODO: Exception, type not found
			}
		}
		
		// if not a bool value error
		if (!(check instanceof BoolValue))
		{
			//TODO: Add an exception here
		}
		
		// do while loop if true
		boolean keepGoing = ((BoolValue)check).getInternalValue();
		
		while (keepGoing)
		{
			tempEnv = sequence.getValue(tempEnv);
			tempEnv = tempEnv.next;
			
			tempEnv = test.getValue(tempEnv);
			check = tempEnv.value;
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
					// TODO: Exception, type not found
				}
			}
			
			keepGoing = ((BoolValue)check).getInternalValue();
		}
			
		return new Environment(tempEnv, null, new VoidValue());
	}

}
