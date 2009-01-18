package test.expression;

import expression.OpEquals;
        import org.junit.*;
        import static org.junit.Assert.*;
import value.IntValue;
import value.BoolValue;
import Interpreter.UnboundIdentifierException;
import Interpreter.ReturnException;
import Interpreter.TypeException;

public class TestOpEquals {
    OpEquals oe1;
    OpEquals oe2;
    OpEquals oe3;

    public TestOpEquals() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        oe1 = new OpEquals(new IntValue(2), new IntValue(2));
        oe2 = new OpEquals(new BoolValue(true), new BoolValue(false));
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpEquals() {
        assertTrue((oe1!=null)&&(oe2!=null)&&(oe3!=null));
    } // testOpEquals()

    @Test
    public void testGetValue() throws UnboundIdentifierException, ReturnException, TypeException {
        boolean res = ((BoolValue)oe1.getValue(null).value).getInternalValue();
        assertTrue(res);
        res = ((BoolValue)oe1.getValue(null).value).getInternalValue();
        assertTrue(!res);

    } // testGetValue()
}
