package expression;

import value.IdValue;
import value.VoidValue;
import Interpreter.Environment;
import test.Testable;

public class OpVarDecl implements Expression {
	
	private String name;

    @Testable
    public OpVarDecl(String name)
	{
		this.name = name;
	}

    @Testable
    @Override
	public Environment getValue(Environment environment) {
		// Add the new environment, and then a reference to the value
		Environment newEnv = new Environment(environment, name, new VoidValue());
		
		// now add the dummy ID ref
		IdValue temp = new IdValue(name);
		
		// now push the id ref on front and return
		return new Environment(newEnv, null, temp);
	}
}
