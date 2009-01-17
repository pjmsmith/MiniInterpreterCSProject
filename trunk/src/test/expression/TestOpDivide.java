package test.expression;

import expression.OpDivide;
import expression.OpMult;
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

public class TestOpDivide {
    private OpDivide od1;
    private OpDivide od2;
    private OpDivide od3;

    public TestOpDivide() {
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
        FloatValue f1 = new FloatValue((float) 6.3);
        BoolValue b1 = new BoolValue(true);
        IdValue idval = new IdValue("testVal");

        od1 = new OpDivide(i1, i1);
        od2 = new OpDivide(f1, idval);
        od3 = new OpDivide(f1, b1);

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpDivide() {
        assertTrue((od1 != null) && (od2 != null) && (od3 != null));
    } // testOpAdd()

    @Test(expected = TypeException.class)
    public void testGetValue() throws ReturnException, TypeException, UnboundIdentifierException {
        //correct integer add 4/4
        int ires = ((IntValue) (od1.getValue(null)).value).getInternalValue();
        assertEquals(ires, 1);
        //correct float add 6.3/5
        float fres = ((FloatValue) (od2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertEquals(fres, 6.3 / 5, 0.001);
        //exception
        ((FloatValue) (od3.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected = UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((FloatValue) (od2.getValue(new Environment(null, "blah", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()

}
