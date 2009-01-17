package test.expression;

import expression.OpDivide;
import expression.OpMult;
import org.junit.*;
        import static org.junit.Assert.*;
import value.IntValue;
import value.FloatValue;
import value.BoolValue;
import value.IdValue;
import Interpreter.*;

public class TestOpDivide {
    private OpDivide od1;
    private OpDivide od2;
    private OpDivide od3;
    private OpDivide od4;

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
        IntValue i2 = new IntValue(0);
        FloatValue f1 = new FloatValue((float) 6.3);
        BoolValue b1 = new BoolValue(true);
        IdValue idval = new IdValue("testVal");

        od1 = new OpDivide(i1, i1);
        od2 = new OpDivide(f1, idval);
        od3 = new OpDivide(f1, b1);
        od4 = new OpDivide(i1, i2);

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpDivide() {
        assertTrue((od1 != null) && (od2 != null) && (od3 != null)&&(od4!=null));
    } // testOpAdd()

    @Test(expected= TypeException.class)
    public void testGetValue() throws ReturnException, TypeException, UnboundIdentifierException {
        //correct integer add 4/4
        float ires = ((FloatValue) (od1.getValue(null)).value).getInternalValue();
        assertEquals(ires, 1.0, 0.001);
        //correct float add 6.3/5
        float fres = ((FloatValue) (od2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertEquals(fres, (float)(6.3 / 5), 0.001);
        try {
            od4.getValue(null);
        }
        catch (TypeException e) {
            //do nothing
        }
        //exception
        ((FloatValue) (od3.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected= UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((FloatValue) (od2.getValue(new Environment(null, "blah", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()
}
