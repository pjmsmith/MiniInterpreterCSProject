package value;

import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import expression.Expression;
import test.Testable;

import java.util.List;

public class Function implements Value{
	private List<String> params;
	private Expression sequence;

    @Testable
    public Function(List<String> params, Expression seq)
	{
		this.params = params;
		sequence = seq;
	}

    @Testable
    public List<String> getParamList()
	{
		return params;
	}
	
    @Testable
	public boolean isType(Value val) {
		return val instanceof Function;
	}

    @Testable
	public Environment getValue(Environment environment) throws ReturnException, TypeException, UnboundIdentifierException  {
		Environment newEnv = null;
		// run the function
		try
		{
			newEnv = sequence.getValue(environment);
		}
		catch (ReturnException e)
		{
			return new Environment(environment, null, e.getRetVal());
		}

		return new Environment(newEnv, null, new VoidValue());
	}

    public String toString()
    {
        String s = "(Function ";
        s+= "(params (";
        String paramStr = "";
        if(params.isEmpty())
        {
            paramStr += "Empty";
        }
        else
        {
            for(String p: params)
            {
                paramStr += p + ", ";
            }
            paramStr = paramStr.substring(0, (paramStr.length()-2));
        }
        s += paramStr;
        s += ")) ";
        s += "\n\t(body (";
        s += sequence;
        s += ")";
        return s;
    }
}
