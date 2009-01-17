package test.expression;

import expression.*;
import org.junit.*;
        import static org.junit.Assert.*;
import Interpreter.TypeException;
import Interpreter.ReturnException;
import Interpreter.Environment;
import Interpreter.UnboundIdentifierException;
import value.BoolValue;
import value.IntValue;
import value.IdValue;

public class TestOr {
    private Or o1;
    private Or o2;
    private Or o3;

    public TestOr() {
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

        o1 = new Or(t, os1);
        o2 = new Or(e1, e2);
        o3 = new Or(i1, new Not(f));
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOr() {
        assertTrue((o1 != null) && (o2 != null) && (o3 != null));
    } // testAnd()

    @Test(expected = TypeException.class)
    public void testGetValue() throws TypeException, ReturnException, UnboundIdentifierException {
        //correct And
        boolean b = ((BoolValue) (o2.getValue(null)).value).getInternalValue();
        assertTrue(b);
        b = ((BoolValue) (o3.getValue(new Environment(null, "testVal", new BoolValue(true)))).value).getInternalValue();
        assertTrue(b);
        //exception
        ((BoolValue) (o1.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected = UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((BoolValue) (o3.getValue(new Environment(null, "blah", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()
}
