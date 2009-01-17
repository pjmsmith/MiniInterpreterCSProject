package test.expression;

import expression.OpLessThan;
import expression.OpGTE;
import expression.OpGreaterThan;
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

public class TestOpGreaterThan {
    private OpGreaterThan ogt1;
    private OpGreaterThan ogt2;
    private OpGreaterThan ogt3;

    public TestOpGreaterThan() {
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

        ogt1 = new OpGreaterThan(i1, i2);
        ogt2 = new OpGreaterThan(f1, idval);
        ogt3 = new OpGreaterThan(i2, b1);

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpAdd() {
        assertTrue((ogt1 != null) && (ogt2 != null) && (ogt3 != null));
    } // testOpAdd()

    @Test(expected = TypeException.class)
    public void testGetValue() throws ReturnException, TypeException, UnboundIdentifierException {
        //correct integer >   4>4
        boolean res = ((BoolValue) (ogt1.getValue(null)).value).getInternalValue();
        assertTrue(res);
        //correct float 5 > 6.3
        res = ((BoolValue) (ogt2.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertTrue(res);
        //exception
        ((BoolValue) (ogt3.getValue(null)).value).getInternalValue();
    } // testGetValue()

    @Test(expected = UnboundIdentifierException.class)
    public void testGetValue2() throws ReturnException, TypeException, UnboundIdentifierException {
        ((BoolValue) (ogt2.getValue(new Environment(null, "blah", new BoolValue(false)))).value).getInternalValue();
    } // testGetValue()

    @Test
    public void testOpGreaterThan() {
        fail(); // @todo - implement
    } // testOpGreaterThan()
}
