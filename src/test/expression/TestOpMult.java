package test.expression;

import expression.OpMult;
import expression.OpAdd;
import org.junit.*;
        import static org.junit.Assert.*;
import value.IntValue;
import value.FloatValue;
import value.BoolValue;
import value.IdValue;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.Environment;

public class TestOpMult {
    private OpMult om1;
    private OpMult om2;
    private OpMult om3;

    public TestOpMult() {
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
        FloatValue f1 = new FloatValue((float)6.3);
        BoolValue b1 = new BoolValue(true);
        IdValue idval = new IdValue("testVal");

        om1 = new OpMult(i1, i1);
        om2 = new OpMult(f1, idval);
        om3 = new OpMult(f1, b1);

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpAdd() {
        assertTrue((om1!=null)&&(om2!=null)&&(om3!=null));
    } // testOpAdd()

    @Test
    public void testGetValue() throws ReturnException, TypeException {
        //correct integer add 4*4
        int ires = ((IntValue)(om1.getValue(null)).value).getInternalValue();
        assertEquals(ires, 16);
        //correct float add 6.3*5
        float fres = ((FloatValue)(om2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertEquals(fres, 6.3*5, 0.001);
        //exception
        ((FloatValue)(om3.getValue(null)).value).getInternalValue();
        //TODO: exception not yet implemented in And class for non-boolean id bindings
        ((FloatValue)(om2.getValue(new Environment(null, "testVal", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()
}

