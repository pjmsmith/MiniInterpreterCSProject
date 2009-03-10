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
    private List<LLVMInstruction> instructions;
    private EFrame ef;
    private int lastEF;
    private int regCnt;
    private String retType;
    private int nextReg;

    public CodeGenerator(StaticPass sp)
    {
        statPass = sp;
        instructions = new ArrayList<LLVMInstruction>();
        regCnt = 2;
        nextReg = 2;
        lastEF = 0;
        ef = new EFrame(null);
        generateCode(statPass.getProgram());
        retType = instructions.get(instructions.size()-1).getType();
    }

    public int generateCode(Expression exp)
    {

        if (exp instanceof Scope) {
            return regCnt;
        }
		else if (exp instanceof Sequence) {
            for(Expression e: ((Sequence)exp).getExpressions())
            {
                regCnt = generateCode(e);
            }
            return regCnt;
        }
		else if (exp instanceof OpVarDecl) {
            return regCnt;
        }
		else if (exp instanceof OpFuncDecl) {
            //define i32 @f_0(i32 %p_0,...i32 %p_n) {
            // ...
            //ret <type> <value> }
            return regCnt;
        }
		else if (exp instanceof ClosureValue) {
            return regCnt;
		}
		else if (exp instanceof And) {
            //not branching if one element in test is false
            return regCnt;
        }
		else if (exp instanceof IsType) {
            return regCnt;
		}
		else if (exp instanceof Not) {
            return regCnt;
		}
		else if (exp instanceof OpAdd) {
            OpAdd a = (OpAdd)exp; //add i32, %0, %1
            int l = generateCode(a.getOne());
            int r = generateCode(a.getTwo());
            AddInstruction ai = new AddInstruction(nextReg, l, r);
            instructions.add(ai);
            nextReg += 4;
            regCnt+= 4;
            return ai.getTargetRegister();
        }
		else if (exp instanceof OpAssign) {
            OpAssign oa = (OpAssign)exp;
            int r = generateCode(oa.getRVal());
            if(oa.getLVal() instanceof OpVarDecl && oa.getRVal() instanceof IntValue)
            {
                OpVarDecl vd = (OpVarDecl)oa.getLVal();
                IntValue iv = (IntValue)oa.getRVal();
                ef.addBinding(vd.getName(), iv);

                int l = generateCode(oa.getLVal());
                instructions.add(new AssignInstruction("i32", nextReg, vd.getName(), r, ef));
            }
            //store <type> <value>, <type>* <target register>, align 4
            nextReg++;
            regCnt++;
            return nextReg-1;
        }
		else if (exp instanceof OpDivide) {
            //sdiv or udiv
            //sdiv i32 %0, %1
            return regCnt;
        }
		else if (exp instanceof OpEquals) {
            //icmp eq i32 %0, %1
            return regCnt;
        }
		else if (exp instanceof OpField) {
            return regCnt;
		}
		else if (exp instanceof OpFunctionCall) {
            //call i32 @f_0(i32 %p_0,...i32 %p_n)
            //if void, add noreturn at the end
            return regCnt;
        }
		else if (exp instanceof OpGreaterThan) {
            //icmp sgt i32 %0, %1
            return regCnt;
        }
		else if (exp instanceof OpGTE) {
            //icmp sge i32 %0, %1
            return regCnt;
        }
		else if (exp instanceof OpIfElse) {
            //translate test, get reg
            //branch label+=1, label+=2
            //label1
                //translate body of then
            //label2
                //translate body of else
            return regCnt;
        }
		else if (exp instanceof OpInstanceOf) {
            return regCnt;
		}
		else if (exp instanceof OpLessThan) {
            //icmp slt i32 %0, %1
            return regCnt;
        }
		else if (exp instanceof OpMult) {
            OpMult m = (OpMult)exp; //add i32, %0, %1
            int l = generateCode(m.getOne());
            int r = generateCode(m.getTwo());
            MultInstruction mi = new MultInstruction(nextReg, l, r);
            instructions.add(mi);
            nextReg++;
            return nextReg-1;
        }
		else if (exp instanceof OpNew) {
            return regCnt;
		}
		else if (exp instanceof OpStringEqual) {
            //call library function written in C
            return regCnt;
        }
		else if (exp instanceof OpStringLess) {
            //call library function written in C
            return regCnt;
        }
		else if (exp instanceof OpSub) {
            OpSub s = (OpSub)exp; //sub i32, %0, %1
            int l = generateCode(s.getOne());
            int r = generateCode(s.getTwo());
            SubInstruction si = new SubInstruction(nextReg, l, r);
            instructions.add(si);
            nextReg++;
            return nextReg-1;
        }
		else if (exp instanceof OpWhile) {
            //generate test, get reg
            //create blocks for: beginning of body, after body
            //generate body code
            return regCnt;
        }
		else if (exp instanceof Or) {
            //branches if one of things in test is true
            return regCnt;
        }
		else if (exp instanceof Print) {
            //call i32 (i8*, ...)* @printf(i8* noalias getelementptr ([4 x i8]* @.str, i32 0, i32 0), i32 %1) nounwind
            return regCnt;
        }
		else if (exp instanceof ReadLine) {
            //call i32 (i8*, ...)* @scanf(i8* noalias getelementptr ([4 x i8]* @.str, i32 0, i32 0), i32 %1) nounwind
            return regCnt;
        }
		else if (exp instanceof Return) {
            ReturnInstruction ret;
            int r = generateCode(((Return)exp).getExp());
            //find out the type of the last register used in the generation of return's expression
            ret = new ReturnInstruction("i32", instructions.get(instructions.size()-1).getTargetRegister());  //i32 for now
            instructions.add(ret);
            return r;
        }
		else if (exp instanceof StringLength) {
            //call a library function written in C
            return regCnt;
        }
		else if (exp instanceof SubString) {
            //call a library function written in C
            return regCnt;
        }
        else if (exp instanceof BoolValue) {
            //add tag bits
            
            return nextReg-1;
        }
        else if (exp instanceof FloatValue) {
            return regCnt;
        }
        else if (exp instanceof IdValue) {

            return nextReg-1;
        }
        else if (exp instanceof Function) {
            return regCnt;
        }
        else if (exp instanceof IntValue) {
            //add tag bits

            return nextReg-1;
        }
        else if (exp instanceof PlainObject) {
            return regCnt;
        }
        else if (exp instanceof StringValue) {
            return regCnt;
        }
        else if (exp instanceof VoidValue) {

            return nextReg-1;
        }
        return -1;
    }

    public int getResult() {
        return regCnt;
    }

    public String toString()
    {
        //target header
        String s = "target datalayout = \"e-p:32:32:32-i1:8:8-i8:8:" +
                "8-i16:16:16-i32:32:32-i64:32:64-f32:32:32-f64:32:64-v64:64:64-v128:128:128-a0:0:64-f80:32:32\"\n" +
                "target triple = \"i386-pc-linux-gnu\"\n";

        //main function wrapper to see results
        s+= "%eframe = type {%eframe*, i32, [0 x i32]}\n";
        s+= "define i32 @llvm_main(){\n" +
                new EFrameInstruction(lastEF, ef);
        //list of instructions
        for(LLVMInstruction l:instructions)
        {
            s+= l + "\n";
        }
        s+="ret " + retType + " %r" + instructions.get(instructions.size()-1).getTargetRegister() + "\n}";
        return s;
    }
}
