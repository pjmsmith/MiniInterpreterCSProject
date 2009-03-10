package staticpass;

import expression.*;
import value.ClosureValue;

import java.util.ArrayList;
import java.util.List;

public class StaticPass {

	private Expression program;
	private List<String> functionNames;
	private List<Integer> functionIds;
	private int nextFuncId = 0;
	private List<String> variableNames;
	private List<Integer> variableFrameCnts;
	private List<Integer> variableFrameNbrs;
	private int scopes;

	public StaticPass(Expression prog) {
		program = prog;
		functionIds = new ArrayList<Integer>();
		functionNames = new ArrayList<String>();
		variableFrameCnts = new ArrayList<Integer>();
		variableFrameNbrs = new ArrayList<Integer>();
		variableNames = new ArrayList<String>();
		scopes = 0;
	}

	public Expression runStaticPass() {
		runNode(program, 0, 0);
		return program;
	}

	private int runNode(Expression exp, int scopeCnt, int varCnt) {
		// Most values do not need to be traversed
		// Right now we only need to count var decl and function declarations
		if (exp instanceof Scope) {
			scopes++;
			runNode(((Scope) exp).getExpression(), scopeCnt + 1, 0);
		} else if (exp instanceof Sequence) {
			List<Expression> expr = ((Sequence) exp).getExpressions();

			// we need to check each of the expressions in the sequence
			for (Expression expression : expr) {
				varCnt = runNode(expression, scopeCnt, varCnt);
			}
		} else if (exp instanceof OpVarDecl) {
			//TODO: The way scope and varCnt are being passed around doesn't seem right.
			OpVarDecl idval = (OpVarDecl) exp;
			variableNames.add(idval.getName());
			idval.setFrameCnt(scopeCnt);
			variableFrameCnts.add(idval.getFrameCnt());
			idval.setFrameNum(varCnt++);
			variableFrameNbrs.add(idval.getFrameNum());
		} else if (exp instanceof OpFuncDecl) {
			OpFuncDecl funcdec = (OpFuncDecl) exp;
			functionNames.add(funcdec.getFuncName());
			functionIds.add(nextFuncId++);
		} else if (exp instanceof ClosureValue) {
			ClosureValue val = (ClosureValue) exp;
			val.setFuncId(nextFuncId);
			functionNames.add("closure");
			functionIds.add(nextFuncId++);
		} else if (exp instanceof And) {
			runNode(((And) exp).getOne(), scopeCnt, varCnt);
			runNode(((And) exp).getTwo(), scopeCnt, varCnt);
		} else if (exp instanceof IsType) {

		} else if (exp instanceof Not) {
			runNode(((Not) exp).getOne(), scopeCnt, varCnt);
		} else if (exp instanceof OpAdd) {
			runNode(((OpAdd) exp).getOne(), scopeCnt, varCnt);
			runNode(((OpAdd) exp).getTwo(), scopeCnt, varCnt);
		} else if (exp instanceof OpAssign) {
			runNode(((OpAssign) exp).getLVal(), scopeCnt, varCnt);
			runNode(((OpAssign) exp).getRVal(), scopeCnt, varCnt);
		} else if (exp instanceof OpDivide) {
			runNode(((OpDivide) exp).getOne(), scopeCnt, varCnt);
			runNode(((OpDivide) exp).getTwo(), scopeCnt, varCnt);
		} else if (exp instanceof OpEquals) {
			runNode(((OpEquals) exp).getLeft(), scopeCnt, varCnt);
			runNode(((OpEquals) exp).getRight(), scopeCnt, varCnt);
		} else if (exp instanceof OpField) {

		} else if (exp instanceof OpFunctionCall) {

		} else if (exp instanceof OpGreaterThan) {
			runNode(((OpGreaterThan) exp).getOne(), scopeCnt, varCnt);
			runNode(((OpGreaterThan) exp).getTwo(), scopeCnt, varCnt);
		} else if (exp instanceof OpGTE) {
			runNode(((OpGTE) exp).getOne(), scopeCnt, varCnt);
			runNode(((OpGTE) exp).getTwo(), scopeCnt, varCnt);
		} else if (exp instanceof OpIfElse) {
			runNode(((OpIfElse) exp).getTest(), scopeCnt, varCnt);
			runNode(((OpIfElse) exp).getFirst(), scopeCnt, varCnt);
			runNode(((OpIfElse) exp).getSecond(), scopeCnt, varCnt);
		} else if (exp instanceof OpInstanceOf) {

		} else if (exp instanceof OpLessThan) {
			runNode(((OpLessThan) exp).getOne(), scopeCnt, varCnt);
			runNode(((OpLessThan) exp).getTwo(), scopeCnt, varCnt);
		} else if (exp instanceof OpMult) {
			runNode(((OpMult) exp).getOne(), scopeCnt, varCnt);
			runNode(((OpMult) exp).getTwo(), scopeCnt, varCnt);
		} else if (exp instanceof OpNew) {

		} else if (exp instanceof OpStringEqual) {

		} else if (exp instanceof OpStringLess) {

		} else if (exp instanceof OpSub) {

		} else if (exp instanceof OpWhile) {
			runNode(((OpWhile) exp).getTest(), scopeCnt, varCnt);
			runNode(((OpWhile) exp).getBody(), scopeCnt, varCnt);
		} else if (exp instanceof Or) {

		} else if (exp instanceof Print) {

		} else if (exp instanceof ReadLine) {

		} else if (exp instanceof Return) {

		} else if (exp instanceof StringLength) {

		} else if (exp instanceof SubString) {

		}

		// return in case we added a variable to this scope
		return varCnt;
	}

	public Expression getProgram() {
		return program;
	}

	public void setProgram(Expression program) {
		this.program = program;
	}

	public List<String> getFunctionNames() {
		return functionNames;
	}

	public void setFunctionNames(List<String> functionNames) {
		this.functionNames = functionNames;
	}

	public List<Integer> getFunctionIds() {
		return functionIds;
	}

	public void setFunctionIds(List<Integer> functionIds) {
		this.functionIds = functionIds;
	}

	public String toString() {
		String spStr = "-Function Names and IDs-\n";
		for (int i = 0; i < functionIds.size(); i++) {
			spStr += functionNames.get(i) + ", " + functionIds.get(i) + "\n";
		}

		spStr += "-Variable names, frame counts, and frame numbers-\n";
		for (int i = 0; i < variableNames.size(); i++) {
			spStr += variableNames.get(i) + ", " + variableFrameCnts.get(i)
					+ ", " + variableFrameNbrs.get(i) + "\n";
		}
		spStr = spStr.substring(0, spStr.length() - 1);
		return spStr;
	}

}
