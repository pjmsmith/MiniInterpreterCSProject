package llvm;

import expression.*;
import staticpass.Scope;
import staticpass.StaticPass;
import value.*;

import java.util.ArrayList;
import java.util.List;

/**
 * llvm: CodeGenerator
 *
 * Description: This class generates the LLVM IR code from the parsed AST
 * after going through the static pass.
 * 
 * @author Patrick J. Smith
 * @date Feb 22, 2009
 */
public class CodeGenerator {

    private StaticPass statPass;
    private int result;

    public CodeGenerator(StaticPass sp)
    {
        statPass = sp;
        result = 0;
    }

    public void generateCode(Expression exp)
    {

        if (exp instanceof Scope) {

        }
		else if (exp instanceof Sequence) {
            for(Expression e: ((Sequence)exp).getExpressions())
            {

            }
        }
		else if (exp instanceof OpVarDecl) {

        }
		else if (exp instanceof OpFuncDecl) {

		}
		else if (exp instanceof ClosureValue) {

		}
		else if (exp instanceof And) {

		}
		else if (exp instanceof IsType) {

		}
		else if (exp instanceof Not) {

		}
		else if (exp instanceof OpAdd) {

        }
		else if (exp instanceof OpAssign) {

        }
		else if (exp instanceof OpDivide) {

        }
		else if (exp instanceof OpEquals) {

        }
		else if (exp instanceof OpField) {

		}
		else if (exp instanceof OpFunctionCall) {

		}
		else if (exp instanceof OpGreaterThan) {

        }
		else if (exp instanceof OpGTE) {

        }
		else if (exp instanceof OpIfElse) {

        }
		else if (exp instanceof OpInstanceOf) {

		}
		else if (exp instanceof OpLessThan) {

        }
		else if (exp instanceof OpMult) {

        }
		else if (exp instanceof OpNew) {

		}
		else if (exp instanceof OpStringEqual) {

		}
		else if (exp instanceof OpStringLess) {

		}
		else if (exp instanceof OpSub) {

		}
		else if (exp instanceof OpWhile) {
            
        }
		else if (exp instanceof Or) {

		}
		else if (exp instanceof Print) {

		}
		else if (exp instanceof ReadLine) {

		}
		else if (exp instanceof Return) {

		}
		else if (exp instanceof StringLength) {

		}
		else if (exp instanceof SubString) {

		}
        else if (exp instanceof BoolValue) {

        }
        else if (exp instanceof FloatValue) {

        }
        else if (exp instanceof IdValue) {

        }
        else if (exp instanceof Function) {

        }
        else if (exp instanceof IntValue) {

        }
        else if (exp instanceof PlainObject) {

        }
        else if (exp instanceof StringValue) {

        }
        else if (exp instanceof VoidValue) {

        }
    }

    public int getResult() {
        return result;
    }


}
