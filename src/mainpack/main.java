package mainpack;

import java.util.LinkedList;
import java.util.List;

import Interpreter.Environment;
import Interpreter.ReturnException;
import value.BoolValue;
import value.Function;
import value.IdValue;
import value.IntValue;
import value.StringValue;
import expression.*;

public class main {
	
	public static void RunSeqTest_1() throws ReturnException 
	{
		List<Expression> firstSeq = new LinkedList<Expression>();
		
		// Add X var
		firstSeq.add(new OpVarDecl("x"));
		
		// Assign x an addition
		Expression temp = new OpAdd(new IntValue(4), new IntValue(6));
		firstSeq.add(new OpAssign(new IdValue("x"), temp));
		
		// now print
		firstSeq.add(new Print(new IdValue("x")));
		
		// now assign one
		firstSeq.add(new OpAssign(new IdValue("x"), new IntValue(1)));
		
		// now print
		firstSeq.add(new Print(new IdValue("x")));
		
		// now assign a string
		firstSeq.add(new OpAssign(new IdValue("x"), new StringValue("TestString out")));
		
		// now print
		firstSeq.add(new Print(new IdValue("x")));
		
		Sequence test = new Sequence(firstSeq);
		
		System.out.println("-----------------------------");
		System.out.println("| SeqTest ONE");
		System.out.println("-----------------------------");
		test.getValue(null);
		
		System.out.println("Output should be: 10, 1, TestString out");
	}
	
	public static void RunSeqTest_2() throws ReturnException 
	{
		List<Expression> firstSeq = new LinkedList<Expression>();
		List<Expression> ifSeq = new LinkedList<Expression>();
		List<Expression> elseSeq = new LinkedList<Expression>();
		
		ifSeq.add(new Print(new StringValue("If was taken")));
		elseSeq.add(new Print(new StringValue("Else was taken")));
		
		// Add X var
		firstSeq.add(new OpVarDecl("x"));
		firstSeq.add(new OpAssign(new IdValue("x"), new BoolValue(true)));
		
		// Testing if and else statements
		firstSeq.add(new OpIfElse(new IdValue("x"), 
				new Sequence(ifSeq), new Sequence(elseSeq)));
		
		// Testing if and else statements
		firstSeq.add(new OpIfElse(new BoolValue(false), 
				new Sequence(ifSeq), new Sequence(elseSeq)));
		
		
		Sequence test = new Sequence(firstSeq);
		
		System.out.println("-----------------------------");
		System.out.println("| SeqTest Two");
		System.out.println("-----------------------------");
		test.getValue(null);
		
		System.out.println("Output should be: If was taken, Else was taken");
	}
	
	public static void RunWhileTest() throws ReturnException 
	{
		List<Expression> firstSeq = new LinkedList<Expression>();
		List<Expression> whileSeq = new LinkedList<Expression>();
		
		// Make Check Expression
		Expression check = new OpLessThan(new IdValue("x"), new IntValue(10));
		
		// make while loop code
		whileSeq.add(new Print(new IdValue("x")));
		// add one
		whileSeq.add(new OpAssign(new IdValue("x"), 
				new OpAdd(new IdValue("x"), new IntValue(1))));
		
		// declare X and assign it a 0
		firstSeq.add(new OpAssign(new OpVarDecl("x"), new IntValue(0)));
		// add while
		firstSeq.add(new OpWhile(check, new Sequence(whileSeq)));
		
		
		
		
		
		Sequence test = new Sequence(firstSeq);
		
		System.out.println("-----------------------------");
		System.out.println("| While Test");
		System.out.println("-----------------------------");
		test.getValue(null);
		
		System.out.println("Output should be: 0, 2, 3, 4, 5, 6, 7, 8, 9");
	}
	
	public static void RunTestFunction() throws ReturnException 
	{
		List<Expression> firstSeq = new LinkedList<Expression>();
		List<Expression> funcSeq = new LinkedList<Expression>();
		List<Expression> args = new LinkedList<Expression>();
		
		List<String> paramList = new LinkedList<String>();
		paramList.add("x");
		paramList.add("y");
		
		args.add(new IntValue(3));
		args.add(new IntValue(10));
		
		funcSeq.add(new Return(new OpAdd(new IdValue("x"), new IdValue("y"))));
		
		Function testFunc = new Function(paramList, new Sequence(funcSeq));
		
		firstSeq.add(new OpFuncDecl(testFunc, "add"));
		firstSeq.add(new Print(new OpFunctionCall(new IdValue("add"), args)));
		
		
		Sequence test = new Sequence(firstSeq);
		
		System.out.println("-----------------------------");
		System.out.println("| Function Test");
		System.out.println("-----------------------------");
		test.getValue(null);
		
		System.out.println("Output should be: 13");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			RunSeqTest_1();
			RunSeqTest_2();
			
			RunWhileTest();
			RunTestFunction();
		} catch (ReturnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
