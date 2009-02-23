package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import test.Testable;
import value.BoolValue;
import value.IdValue;
import value.Value;

public class Not implements Expression {
	
	private Expression one;

    @Testable
    public Not(Expression one)
	{
		this.one = one;
	}

    public Expression getOne() {
        return one;
    }

    @Testable
	public Environment getValue(Environment environment) throws ReturnException, TypeException, UnboundIdentifierException {
		Environment nEnv = one.getValue(environment);
		Value leftSide = nEnv.value;
		nEnv = nEnv.next;
		
		// check to see if one of them is an ID
		if (leftSide instanceof IdValue)
		{
			String name = ((IdValue)leftSide).getInternalValue();
			Environment environ = Environment.findIDInList(name, nEnv);
			// check for null
			if (environ != null)
			{
				leftSide = environ.value;
			}
			else
			{
				throw new UnboundIdentifierException();
			}
		}
		// now check to make sure its a bool
		if (!(leftSide instanceof BoolValue))
		{
			throw new TypeException();
		}
		
		boolean ls = ((BoolValue)leftSide).getInternalValue();
			
		return new Environment(environment, null, new BoolValue(!ls));
	}

    public String toString()
    {
        return "(Not " + one + ")";
    }
}
