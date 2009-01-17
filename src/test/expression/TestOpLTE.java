package test.expression;

import expression.OpLTE;
import expression.OpLessThan;
import org.junit.*;
        import static org.junit.Assert.*;
import value.IntValue;
import value.FloatValue;
import value.BoolValue;
import value.IdValue;
import Interpreter.TypeException;
import Interpreter.ReturnException;
import Interpreter.Environment;
import Interpreter.UnboundIdentifierException;

public class TestOpLTE {
    private OpLTE olte1;
    private OpLTE olte2;
    private OpLTE olte3;

    public TestOpLTE() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        IntValue i1 = new IntValue(4);
        IntValue i2 = new IntValue(2);
        FloatValue f1 = new FloatValue((float) 6.3);
        BoolValue b1 = new BoolValue(true);
        IdValue idval = new IdValue("testVal");

        olte1 = new OpLTE(i1, i1);
        olte2 = new OpLTE(idval, f1);
        olte3 = new OpLTE(i2, b1);

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpLTE() {
        assertTrue((olte1 != null) && (olte2 != null) && (olte3 != null));
    } // testOpAdd()

    @Test(expected = TypeException.class)
    public void testGetValue() throws ReturnException, TypeException, UnboundIdentifierException {
        //correct integer <   4<=4
        boolean res = ((BoolValue) (olte1.getValue(null)).value).getInternalValue();
        assertTrue(res);
        //correct float 5 <= 6.3
        res = ((BoolValue) (olte2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertTrue(res);
        //exception
        ((BoolValue) (olte3.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected = UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((BoolValue) (olte2.getValue(new Environment(null, "blah", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()
}