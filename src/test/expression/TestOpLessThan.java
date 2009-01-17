package test.expression;

import expression.OpLessThan;
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

public class TestOpLessThan {
    private OpLessThan olt1;
    private OpLessThan olt2;
    private OpLessThan olt3;

    public TestOpLessThan() {
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

        olt1 = new OpLessThan(i2, i1);
        olt2 = new OpLessThan(idval, f1);
        olt3 = new OpLessThan(f1, b1);

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpLessThan() {
        assertTrue((olt1 != null) && (olt2 != null) && (olt3 != null));
    } // testOpAdd()

    @Test(expected = TypeException.class)
    public void testGetValue() throws ReturnException, TypeException, UnboundIdentifierException {
        //correct integer <   2<4
        boolean res = ((BoolValue) (olt1.getValue(null)).value).getInternalValue();
        assertTrue(res);
        //correct float 5 < 6.3
        res = ((BoolValue) (olt2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertTrue(res);
        //exception
        ((BoolValue) (olt3.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected = UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((BoolValue) (olt2.getValue(new Environment(null, "blah", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()

}

