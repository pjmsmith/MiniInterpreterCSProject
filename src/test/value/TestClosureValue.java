package test.value;

import value.ClosureValue;
import value.IntValue;
import value.Function;
import org.junit.*;
        import static org.junit.Assert.*;

import java.util.ArrayList;

import expression.Expression;
import expression.OpAdd;
import expression.Sequence;
import Interpreter.Environment;
import Interpreter.ReturnException;

public class TestClosureValue {
    private ClosureValue cv1;

    public TestClosureValue() {
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
        cv1 = new ClosureValue(new Function(params, seq));
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testClosureValue() {
        assertTrue(cv1!=null);
    } // testClosureValue()

    @Test
    public void testSetEnvironment() {
        cv1.setEnvironment(new Environment(null, "testVal", new IntValue(3)));
        assertTrue(((IntValue)cv1.getEnvironment().value).getInternalValue()==3);
    } // testSetEnvironment()

    @Test
    public void testGetEnvironment() {
        cv1.setEnvironment(new Environment(null, "testVal", new IntValue(3)));
        assertTrue(((IntValue)cv1.getEnvironment().value).getInternalValue()==3);
    } // testGetEnvironment()

    @Test
    public void testGetIntFunc() {
       assertTrue(cv1.getIntFunc()!=null);
    } // testGetIntFunc()

    @Test
    public void testIsType() {
        assertTrue(cv1.isType(cv1));
    } // testIsType()

    @Test
    public void testGetValue() throws ReturnException {
        assertTrue(cv1.getValue(null)!=null);
    } // testGetValue()
}
