package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;
import value.BoolValue;
import value.IdValue;
import value.Value;
import value.VoidValue;

public class OpWhile implements Expression {
	
	private Expression test;
	private Expression sequence;

    @Testable
    public OpWhile(Expression exp, Expression seq)
	{
		test = exp;
		sequence = seq;
	}
    
    public Expression getTest() {
    	return test;
    }
    
    public Expression getBody() {
    	return sequence;
    }

    @Testable
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
				throw new UnboundIdentifierException();
			}
		}
		
		// if not a bool value error
		if (!(check instanceof BoolValue))
		{
			throw new TypeException();
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
			//TODO: make sure this works with Sequence (re-test)
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
			
			keepGoing = ((BoolValue)check).getInternalValue();
		}
			
		return new Environment(tempEnv, null, new VoidValue());
	}

    public String toString()
    {
        return "(While " + test + " \n\t(body " + sequence + "))\n";
    }
}
