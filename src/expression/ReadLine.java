package expression;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import test.Testable;
import value.StringValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLine implements Expression {

    @Testable
    public ReadLine()
	{
		
	}

    @Testable
	public Environment getValue(Environment environment)
			throws ReturnException, TypeException {
	    
		// read in a line
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String readLine = null;
	    
	    try {
	    	readLine = br.readLine() + "\n";
	    } catch (IOException e) {
	        throw new TypeException();
	    }

		return new Environment(environment, null, new StringValue(readLine));
	}

    public String toString()
    {
        return "(ReadLine)";
    }
}
