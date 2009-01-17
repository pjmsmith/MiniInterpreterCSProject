package expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import value.StringValue;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;

public class ReadLine implements Expression {
	
	public ReadLine()
	{
		
	}

	@Override
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

}
