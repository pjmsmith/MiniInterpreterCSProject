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
    private List<FunctionDeclarationInstruction> functions;
    private EFrame ef;
    private int lastEF;
    private String retType;
    private int nextReg;

    public CodeGenerator(StaticPass sp)
    {
        statPass = sp;
        instructions = new ArrayList<LLVMInstruction>();
        functions = new ArrayList<FunctionDeclarationInstruction>();
        nextReg = 2;
        lastEF = 0;
        ef = new EFrame(null);
        generateCode(statPass.getProgram());
        System.out.println(statPass.getProgram());
        if(instructions.size()-1 > 0)
        {
            retType = instructions.get(instructions.size()-1).getType();
        }
    }

    public int generateCode(Expression exp)
    {
        if (exp instanceof Scope) {
            generateCode(((Scope)exp).getExpression());
            return nextReg;
        }
		else if (exp instanceof Sequence) {
            for(Expression e: ((Sequence)exp).getExpressions())
            {
                nextReg = generateCode(e);
            }
            return nextReg;
        }
		else if (exp instanceof OpVarDecl) {
            return nextReg;
        }
		else if (exp instanceof OpFuncDecl) {
            //define i32 @f_0(i32 %p_0,...i32 %p_n) {
            // ...
            //ret <type> <value> }
            return nextReg;
        }
		else if (exp instanceof ClosureValue) {
            return nextReg;
		}
		else if (exp instanceof And) {
            //not branching if one element in test is false
            return nextReg;
        }
		else if (exp instanceof IsType) {
            return nextReg;
		}
		else if (exp instanceof Not) {
            return nextReg;
		}
		else if (exp instanceof OpAdd) {
            OpAdd a = (OpAdd)exp; //add i32, %0, %1
            int l = generateCode(a.getOne());
            int r = generateCode(a.getTwo());
            if(a.getOne() instanceof IntValue)
            {
                instructions.add(new LoadInstruction(nextReg, l));
                l = nextReg;
                nextReg++;
            }
            if(a.getTwo() instanceof IntValue)
            {
                instructions.add(new LoadInstruction(nextReg, r));
                r = nextReg;
                nextReg++;
            }
            instructions.add(new AddInstruction(nextReg, l, r));
            nextReg++;
            return nextReg-1;
        }
		else if (exp instanceof OpAssign) {
            OpAssign oa = (OpAssign)exp;
            int r = generateCode(oa.getRVal());
            Expression name = oa.getLVal();
            if(name instanceof OpVarDecl)
            {
                //add to eframe
            }

            return nextReg-1;
        }
		else if (exp instanceof OpDivide) {
            //sdiv or udiv
            //sdiv i32 %0, %1
            OpDivide d = (OpDivide)exp;
            int l = generateCode(d.getOne());
            int r = generateCode(d.getTwo());
            boolean sdiv = false;
            if(d.getOne() instanceof IntValue)
            {
                instructions.add(new LoadInstruction(nextReg, l));
                nextReg++;
                instructions.add(new LogicalShiftRightInstruction(nextReg, nextReg-1, 2));
                l = nextReg;
                nextReg++;
            }
            if(d.getTwo() instanceof IntValue)
            {
                instructions.add(new LoadInstruction(nextReg, r));
                nextReg++;
                instructions.add(new LogicalShiftRightInstruction(nextReg, nextReg-1, 2));
                r = nextReg;
                nextReg++;
            }

            if(sdiv)
            {
                instructions.add(new SDivInstruction(nextReg, l, r));
            }
            else
            {
                instructions.add(new UDivInstruction(nextReg, l, r));   
            }
            instructions.add(new ShiftLeftInstruction(nextReg, nextReg-1, 2));
            nextReg++;
            return nextReg-1;
        }
		else if (exp instanceof OpEquals) {
            //icmp eq i32 %0, %1
            return nextReg;
        }
		else if (exp instanceof OpField) {
            return nextReg;
		}
		else if (exp instanceof OpFunctionCall) {
            //call i32 @f_0(i32 %p_0,...i32 %p_n)
            //if void, add noreturn at the end
            return nextReg;
        }
		else if (exp instanceof OpGreaterThan) {
            //icmp sgt i32 %0, %1
            return nextReg;
        }
		else if (exp instanceof OpGTE) {
            //icmp sge i32 %0, %1
            return nextReg;
        }
		else if (exp instanceof OpIfElse) {
            //translate test, get reg
            //branch label+=1, label+=2
            //label1
                //translate body of then
            //label2
                //translate body of else
            return nextReg;
        }
		else if (exp instanceof OpInstanceOf) {
            return nextReg;
		}
		else if (exp instanceof OpLessThan) {
            //icmp slt i32 %0, %1
            return nextReg;
        }
		else if (exp instanceof OpMult) {
            OpMult m = (OpMult)exp; //mul i32, %0, %1
            int l = generateCode(m.getOne());
            int r = generateCode(m.getTwo());
            if(m.getOne() instanceof IntValue)
            {
                instructions.add(new LoadInstruction(nextReg, l));
                nextReg++;
                instructions.add(new LogicalShiftRightInstruction(nextReg, nextReg-1, 2));
                l = nextReg;
                nextReg++;
            }
            if(m.getTwo() instanceof IntValue)
            {
                instructions.add(new LoadInstruction(nextReg, r));
                nextReg++;
                instructions.add(new LogicalShiftRightInstruction(nextReg, nextReg-1, 2));
                r = nextReg;
                nextReg++;
            }
            instructions.add(new MultInstruction(nextReg, l, r));
            nextReg++;
            instructions.add(new ShiftLeftInstruction(nextReg, nextReg-1, 2));
            nextReg++;
            return nextReg-1;
        }
		else if (exp instanceof OpNew) {
            return nextReg;
		}
		else if (exp instanceof OpStringEqual) {
            //call library function written in C
            return nextReg;
        }
		else if (exp instanceof OpStringLess) {
            //call library function written in C
            return nextReg;
        }
		else if (exp instanceof OpSub) {
            OpSub s = (OpSub)exp; //sub i32, %0, %1
            int l = generateCode(s.getOne());
            int r = generateCode(s.getTwo());
            if(s.getOne() instanceof IntValue)
            {
                instructions.add(new LoadInstruction(nextReg, l));
                nextReg++;
                instructions.add(new LogicalShiftRightInstruction(nextReg, nextReg-1, 2));
                l = nextReg;
                nextReg++;
            }
            if(s.getTwo() instanceof IntValue)
            {
                instructions.add(new LoadInstruction(nextReg, r));
                nextReg++;
                instructions.add(new LogicalShiftRightInstruction(nextReg, nextReg-1, 2));
                r = nextReg;
                nextReg++;
            }
            instructions.add(new SubInstruction(nextReg, l, r));
            nextReg++;
            instructions.add(new ShiftLeftInstruction(nextReg, nextReg-1, 2));
            nextReg++;
            return nextReg-1;
        }
		else if (exp instanceof OpWhile) {
            //generate test, get reg
            //create blocks for: beginning of body, after body
            //generate body code
            return nextReg;
        }
		else if (exp instanceof Or) {
            //branches if one of things in test is true
            return nextReg;
        }
		else if (exp instanceof Print) {
            //call i32 (i8*, ...)* @printf(i8* noalias getelementptr ([4 x i8]* @.str, i32 0, i32 0), i32 %1) nounwind
            return nextReg;
        }
		else if (exp instanceof ReadLine) {
            //call i32 (i8*, ...)* @scanf(i8* noalias getelementptr ([4 x i8]* @.str, i32 0, i32 0), i32 %1) nounwind
            return nextReg;
        }
		else if (exp instanceof Return) {
            ReturnInstruction ret;

            return nextReg;
        }
		else if (exp instanceof StringLength) {
            //call a library function written in C
            return nextReg;
        }
		else if (exp instanceof SubString) {
            //call a library function written in C
            return nextReg;
        }
        else if (exp instanceof BoolValue) {
            //add tag bits
            instructions.add(new MallocInstruction(nextReg, "i32", ""));
            int tagged = 7;
            if((((BoolValue)exp).getInternalValue()))
            {
                tagged = tagged << 1;
                tagged++;
            }
            String shiftedVal = ((Integer)tagged).toString();
            instructions.add(new StoreInstruction(nextReg, "i32", shiftedVal));
            nextReg++;
            return nextReg-1;
        }
        else if (exp instanceof FloatValue) {
            return nextReg;
        }
        else if (exp instanceof IdValue) {

            return nextReg-1;
        }
        else if (exp instanceof Function) {
            return nextReg;
        }
        else if (exp instanceof IntValue) {
            //add tag bits
            instructions.add(new MallocInstruction(nextReg, "i32", ""));
            String shiftedVal = ((Integer)(((IntValue)exp).getInternalValue()<<2)).toString();
            instructions.add(new StoreInstruction(nextReg, "i32", shiftedVal));
            nextReg++;
            return nextReg-1;
        }
        else if (exp instanceof PlainObject) {
            return nextReg;
        }
        else if (exp instanceof StringValue) {
            return nextReg;
        }
        else if (exp instanceof VoidValue) {

            return nextReg-1;
        }
        return -1;
    }

    public int getResult() {
        return nextReg;
    }

    public String toString()
    {
        //target header
        String s = "target datalayout = \"e-p:32:32:32-i1:8:8-i8:8:" +
                "8-i16:16:16-i32:32:32-i64:32:64-f32:32:32-f64:32:64-v64:64:64-v128:128:128-a0:0:64-f80:32:32\"\n" +
                "target triple = \"i386-pc-linux-gnu\"\n";
        String eframeType = "{%eframe*, i32, [" + ef.getNumElements() + " x i32]}";
        //main function wrapper to see results
        s+= "%eframe = type {%eframe*, i32, [0 x i32]}\n";
        for(FunctionDeclarationInstruction f: functions)
        {
            s+= f + "\n";
        }
        s+= "define i32 @llvm_main(){\n" +
                new MallocInstruction(0, eframeType, "") + "\n" +
                new BitCastInstruction(1, eframeType + "*", "%r0", "%eframe*") + "\n";
        //list of instructions
        for(LLVMInstruction l:instructions)
        {
            s+= l + "\n";
        }
        //TODO: figure out whether the result of the last instruction needs loading
        /*s+= new LoadInstruction(nextReg+1, nextReg) + "\n";
        nextReg++;*/
        s+= new ReturnInstruction("i32", nextReg);
        s+= "\n}";
        return s;
    }
}
