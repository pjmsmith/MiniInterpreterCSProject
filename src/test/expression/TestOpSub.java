package test.expression;

import expression.OpSub;
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
import Interpreter.UnboundIdentifierException;

public class TestOpSub {
    private OpSub os1;
    private OpSub os2;
    private OpSub os3;

    public TestOpSub() {
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

        os1 = new OpSub(i1, i1);
        os2 = new OpSub(f1, idval);
        os3 = new OpSub(f1, b1);

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpAdd() {
        assertTrue((os1!=null)&&(os2!=null)&&(os3!=null));
    } // testOpAdd()

    @Test(expected= TypeException.class)
    public void testGetValue() throws ReturnException, TypeException, UnboundIdentifierException {
        //correct integer add 4-4
        int ires = ((IntValue)(os1.getValue(null)).value).getInternalValue();
        assertEquals(ires, 0);
        //correct float add 6.3-5
        float fres = ((FloatValue)(os2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertEquals(fres, 1.3, 0.001);
        //exception
        ((FloatValue)(os3.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected= UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((BoolValue)(os2.getValue(new Environment(null, "blah", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()
}