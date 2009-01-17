package test.expression;

import expression.OpGTE;
import expression.OpLTE;
import org.junit.*;
        import static org.junit.Assert.*;
import value.IntValue;
import value.FloatValue;
import value.BoolValue;
import value.IdValue;
import Interpreter.TypeException;
import Interpreter.ReturnException;
import Interpreter.Environment;

public class TestOpGTE {
    private OpGTE ogte1;
    private OpGTE ogte2;
    private OpGTE ogte3;

    public TestOpGTE() {
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
        FloatValue f1 = new FloatValue((float)6.3);
        BoolValue b1 = new BoolValue(true);
        IdValue idval = new IdValue("testVal");

        ogte1 = new OpGTE(i1, i1);
        ogte2 = new OpGTE(f1, idval);
        ogte3 = new OpGTE(i2, b1);

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpAdd() {
        assertTrue((ogte1!=null)&&(ogte2!=null)&&(ogte3!=null));
    } // testOpAdd()

    @Test(expected= TypeException.class)
    public void testGetValue() throws ReturnException, TypeException {
        //correct integer >=   4>=4
        boolean res = ((BoolValue)(ogte1.getValue(null)).value).getInternalValue();
        assertTrue(res);
        //correct float 5 >= 6.3
        res = ((BoolValue)(ogte2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertTrue(res);
        //exception
        ((BoolValue)(ogte3.getValue(null)).value).getInternalValue();
        //TODO: exception not yet implemented in And class for non-boolean id bindings
        ((BoolValue)(ogte2.getValue(new Environment(null, "testVal", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()
}
