package llvm;

import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import expression.*;
import value.BoolValue;
import value.IntValue;
import value.VoidValue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * llvm: CodeGenerator
 *
 * Description: This class generates the LLVM IR code from the parsed AST.
 *  NOTE: Mutation isn't being represented in LLVM yet, i.e. if(x < 4) { x = x + 1; }
 * 
 * @author Patrick J. Smith
 * @date Feb 4, 2009
 */
public class CodeGenerator {

    private String ir;
    //Label counter
    private int lcnt;
    //Register counter
    private int rcnt;
    public void setIr(String ir)
    {
        this.ir = ir;
        this.lcnt = 0;
        this.rcnt = 0;
    }

    public CodeGenerator()
    {
        ir = null;
    }

    public String generateCode(Expression exp) throws UnboundIdentifierException, ReturnException, TypeException {
        String code = "";
        if(exp instanceof Sequence)
        {
            for(Expression e: ((Sequence)exp).getExpressions())
            {
                code += generateCode(e) + "\n";
            }
        }
        else if(exp instanceof IntValue)
        {
            int val = ((IntValue)(exp.getValue(null)).value).getInternalValue();
            code = "i32 " + val;
        }
        else if(exp instanceof BoolValue)
        {
            boolean val = ((BoolValue)(exp.getValue(null)).value).getInternalValue();
            code = "i32 " + val;
        }
        else if(exp instanceof VoidValue)
        {
            code = "void";
        }
        else if(exp instanceof OpAdd)
        {
            code = "add i32 " + trimTypes(generateCode(((OpAdd)exp).getOne())) + ", "
                    + trimTypes(generateCode(((OpAdd)exp).getTwo()));
        }
        else if(exp instanceof OpSub)
        {
            code = "sub i32 " + trimTypes(generateCode(((OpSub)exp).getOne())) + ", "
                    + trimTypes(generateCode(((OpSub)exp).getTwo()));
        }
        else if(exp instanceof OpMult)
        {
            code = "mul i32 " + trimTypes(generateCode(((OpMult)exp).getOne())) + ", "
                    + trimTypes(generateCode(((OpMult)exp).getTwo()));
        }
        else if(exp instanceof OpDivide)
        {
            //TODO: After floats are translated, add a check to decide between udiv, sdiv, and fdiv
            code = "udiv i32 " + trimTypes(generateCode(((OpDivide)exp).getOne())) + ", "
                    + trimTypes(generateCode(((OpDivide)exp).getTwo()));
        } //TODO: Make sure that boolean operators are logical and can just be reduced to true or false here
        else if(exp instanceof Not)
        {
            String test = trimTypes(generateCode(((Not)exp).getOne()));
            if(Boolean.valueOf(test))
            {
                code = "i32 false";
            }
            else code = "i32 true";
        }
        else if(exp instanceof And)
        {
            String left = trimTypes(generateCode(((And)exp).getOne()));
            String right = trimTypes(generateCode(((And)exp).getTwo()));

            if(Boolean.valueOf(left) && Boolean.valueOf(right))
            {
                code = "i32 true";
            }
            else code = "i32 false";
                
        }
        else if(exp instanceof Or)
        {
            String left = trimTypes(generateCode(((Or)exp).getOne()));
            String right = trimTypes(generateCode(((Or)exp).getTwo()));

            if(Boolean.valueOf(left) || Boolean.valueOf(right))
            {
                code = "i32 true";
            }
            else code = "i32 false";
        }
        else if(exp instanceof OpLessThan)
        {
            String left = trimTypes(generateCode(((OpLessThan)exp).getOne()));
            String right = trimTypes(generateCode(((OpLessThan)exp).getTwo()));

            if(Double.valueOf(left) < Double.valueOf(right))
            {
                code = "i32 true";
            }
            else code = "i32 false";
        }
        else if(exp instanceof OpGreaterThan)
        {
            String left = trimTypes(generateCode(((OpGreaterThan)exp).getOne()));
            String right = trimTypes(generateCode(((OpGreaterThan)exp).getTwo()));

            if(Double.valueOf(left) > Double.valueOf(right))
            {
                code = "i32 true";
            }
            else code = "i32 false";
        }
        else if(exp instanceof OpLTE)
        {
            String left = trimTypes(generateCode(((OpLTE)exp).getOne()));
            String right = trimTypes(generateCode(((OpLTE)exp).getTwo()));

            if(Double.valueOf(left) <= Double.valueOf(right))
            {
                code = "i32 true";
            }
            else code = "i32 false";
        }
        else if(exp instanceof OpGTE)
        {
            String left = trimTypes(generateCode(((OpGTE)exp).getOne()));
            String right = trimTypes(generateCode(((OpGTE)exp).getTwo()));

            if(Double.valueOf(left) >= Double.valueOf(right))
            {
                code = "i32 true";
            }
            else code = "i32 false";
        }
        else if(exp instanceof OpEquals)
        {
            String left = trimTypes(generateCode(((OpEquals)exp).getLeft()));
            String right = trimTypes(generateCode(((OpEquals)exp).getRight()));

            if(Double.valueOf(left).equals(Double.valueOf(right)))
            {
                code = "i32 true";
            }
            else code = "i32 false";

        }
        else if(exp instanceof OpIfElse)
        {
            int condreg = rcnt;
            int labelthen = lcnt;
            int labelelse = lcnt+1;
            int labelfinal = lcnt+2;
            code = "%r"+(rcnt++) +" = ";
            code += generateCode(((OpIfElse)exp).getTest());
            code += "\n";
            code += "br i1 %r"+condreg+", label %L"+(lcnt++)+", label %L"+(lcnt++);
            code += "\n";
            code += "L"+labelthen+":";
            code += "\n";
            code += generateCode(((OpIfElse)exp).getFirst());
            code += "br label %L"+(lcnt++);
            code += "\n";
            code += "L"+labelelse+":";
            code += generateCode(((OpIfElse)exp).getSecond());
            code += "br label %L"+labelfinal;
            code += "\n";
            code += "L"+labelfinal+":";
        }
        return code;
    }

    private String trimTypes(String s) {
        if(s.contains("i32 "))
        {
            return s.substring(4);
        }
        else return s;
    }

    public void toLLVMFile()
    {
        try {
                BufferedWriter out = new BufferedWriter(new FileWriter("my-footle.s"));
                out.write(ir);
                out.close();
            } catch (IOException e) {
                System.out.println("Could not write to file.");
                System.exit(-1);
            }
    }

    public String toString()
    {
        return ir;
    }
}
