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

    @Test
    public void testGetValue() throws ReturnException, TypeException {
        //correct integer add 4+4
        int ires = ((IntValue)(oa1.getValue(null)).value).getInternalValue();
        assertEquals(ires, 8);
        //correct float add 6.3+5
        float fres = ((FloatValue)(oa2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertEquals(fres, 11.3, 0.001);
        //exception
        ((FloatValue)(oa3.getValue(null)).value).getInternalValue();
        //TODO: exception not yet implemented in And class for non-boolean id bindings
        ((FloatValue)(oa2.getValue(new Environment(null, "testVal", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()
}
