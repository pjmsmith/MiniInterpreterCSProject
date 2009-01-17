package test.expression;

import expression.OpAdd;
        import org.junit.*;
        import static org.junit.Assert.*;
import value.IntValue;
import value.FloatValue;
import value.BoolValue;
import value.IdValue;
import Interpreter.Environment;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;

public class TestOpAdd {
    private OpAdd oa1;
    private OpAdd oa2;
    private OpAdd oa3;

    public TestOpAdd() {
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

        oa1 = new OpAdd(i1, i1);
        oa2 = new OpAdd(f1, idval);
        oa3 = new OpAdd(f1, b1);

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpAdd() {
        assertTrue((oa1!=null)&&(oa2!=null)&&(oa3!=null));
    } // testOpAdd()

    @Test(expected= TypeException.class)
    public void testGetValue() throws ReturnException, TypeException, UnboundIdentifierException {
        //correct integer add 4+4
        int ires = ((IntValue)(oa1.getValue(null)).value).getInternalValue();
        assertEquals(ires, 8);
        //correct float add 6.3+5
        float fres = ((FloatValue)(oa2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertEquals(fres, 11.3, 0.001);
        //exception
        ((FloatValue)(oa3.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected= UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((BoolValue)(oa2.getValue(new Environment(null, "blah", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()
}
