package test.expression;

import expression.*;
import org.junit.*;
        import static org.junit.Assert.*;
import value.BoolValue;
import value.IntValue;
import value.IdValue;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;

public class TestNot {
    private Not n1;
    private Not n2;
    private Not n3;

    public TestNot() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        Expression e1 = new OpLessThan(new IntValue(3), new IntValue(4));
        IdValue i1 = new IdValue("testVal");
        OpSub os1 = new OpSub(new IntValue(3), new IntValue(2));

        n1 = new Not(os1);
        n2 = new Not(e1);
        n3 = new Not(i1);
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testNot() {
        assertTrue((n1!=null)&&(n2!=null)&&(n3!=null));
    } // testNot()

    @Test(expected= TypeException.class)
    public void testGetValue() throws ReturnException, TypeException, UnboundIdentifierException {
        //correct And
        boolean b = ((BoolValue)(n2.getValue(null)).value).getInternalValue();
        assertTrue(!b);
        b = ((BoolValue)(n3.getValue(new Environment(null, "testVal", new BoolValue(true)))).value).getInternalValue();
        assertTrue(!b);
        //exception
        ((BoolValue)(n1.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected= UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((BoolValue)(n3.getValue(null)).value).getInternalValue();
    } // testGetValue()
}
