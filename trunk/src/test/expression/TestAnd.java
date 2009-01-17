package test.expression;

import expression.*;
import org.junit.*;
        import static org.junit.Assert.*;
import value.BoolValue;
import value.IntValue;
import value.IdValue;
import Interpreter.ReturnException;
import Interpreter.Environment;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;

public class TestAnd {
    private And a1;
    private And a2;
    private And a3;

    public TestAnd() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        BoolValue t = new BoolValue(true);
        BoolValue f = new BoolValue(false);
        Expression e1 = new OpLessThan(new IntValue(3), new IntValue(4));
        Expression e2 = new OpGTE(new IntValue(4), new IntValue(4));
        IdValue i1 = new IdValue("testVal");
        OpSub os1 = new OpSub(new IntValue(3), new IntValue(2));

        a1 = new And(t, os1);
        a2 = new And(e1, e2);
        a3 = new And(i1, new Not(f));
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testAnd() {
        assertTrue((a1!=null)&&(a2!=null)&&(a3!=null));
    } // testAnd()

    @Test(expected= TypeException.class)
    public void testGetValue() throws TypeException, ReturnException, UnboundIdentifierException {
        //correct And
        boolean b = ((BoolValue)(a2.getValue(null)).value).getInternalValue();
        assertTrue(b);
        b = ((BoolValue)(a3.getValue(new Environment(null, "testVal", new BoolValue(true)))).value).getInternalValue();
        assertTrue(b);
        //exception
        ((BoolValue)(a1.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected= UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((BoolValue)(a3.getValue(new Environment(null, "blah", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()
}
