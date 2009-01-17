package test.value;

import value.Function;
import value.IntValue;
import org.junit.*;
        import static org.junit.Assert.*;

import java.util.ArrayList;

import expression.Sequence;
import expression.Expression;
import expression.OpAdd;
import Interpreter.UnboundIdentifierException;
import Interpreter.ReturnException;
import Interpreter.TypeException;

public class TestFunction {
    private Function f1;

    public TestFunction() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        ArrayList<String> params = new ArrayList<String>();
        params.add("a");
        params.add("b");
        params.add("c");
        ArrayList<Expression> ls = new ArrayList<Expression>();
        ls.add(new OpAdd(new IntValue(3), new IntValue(4)));
        Sequence seq = new Sequence(ls);
        f1 = new Function(params, seq);
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testFunction() {
        assertTrue(f1!=null);
    } // testFunction()

    @Test
    public void testGetParamList() {
        assertTrue(f1.getParamList().size() == 3);
    } // testGetParamList()

    @Test
    public void testIsType() {
        assertTrue(f1.isType(f1));
    } // testIsType()

    @Test
    public void testGetValue() throws UnboundIdentifierException, ReturnException, TypeException {
        assertTrue(f1.getValue(null)!=null);
    } // testGetValue()
}
