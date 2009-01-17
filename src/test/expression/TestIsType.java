package test.expression;

import expression.IsType;
import expression.Sequence;
import expression.Expression;
import expression.OpAdd;
import org.junit.*;
        import static org.junit.Assert.*;
import value.*;

import java.util.ArrayList;

import Interpreter.UnboundIdentifierException;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.Environment;

public class TestIsType {
    IsType it1;
    IsType it2;
    IsType it3;
    IsType it4;
    IsType it5;
    IsType it6;
    IsType it7;
    IsType it8;
    IsType it9;

    public TestIsType() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        IntValue i1 = new IntValue(3);
        BoolValue b1 = new BoolValue(true);
        IdValue idval = new IdValue("testVal");
        PlainObject po1 = new PlainObject();
        FloatValue f1 = new FloatValue((float)3.4);
        StringValue s1 = new StringValue("Hello");
        VoidValue v1 = new VoidValue();
        ClosureValue c1 = new ClosureValue(new Function(new ArrayList<String>(), new Sequence(new ArrayList<Expression>())));

        it1 = new IsType(i1.getClass(), i1);
        it2 = new IsType(b1.getClass(), b1);
        it3 = new IsType(po1.getClass(), po1);
        it4 = new IsType(f1.getClass(), f1);
        it5 = new IsType(s1.getClass(), s1);
        it6 = new IsType(v1.getClass(), v1);
        it7 = new IsType(c1.getClass(), c1);
        it8 = new IsType(i1.getClass(), b1);
        it9 = new IsType(i1.getClass(), idval);
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testIsType() {
        assertTrue((it1!=null)&&(it2!=null)&&(it3!=null)&&(it4!=null)&&(it5!=null)&&(it6!=null)&&(it7!=null)&&(it8!=null)&&(it9!=null));
    } // testIsType()

    @Test
    public void testGetValue() throws UnboundIdentifierException, ReturnException, TypeException {
        boolean res = ((BoolValue)(it1.getValue(null).value)).getInternalValue();
        assertTrue(res);
        res = ((BoolValue)(it2.getValue(null).value)).getInternalValue();
        assertTrue(res);
        res = ((BoolValue)(it3.getValue(null).value)).getInternalValue();
        assertTrue(res);
        res = ((BoolValue)(it4.getValue(null).value)).getInternalValue();
        assertTrue(res);
        res = ((BoolValue)(it5.getValue(null).value)).getInternalValue();
        assertTrue(res);
        res = ((BoolValue)(it6.getValue(null).value)).getInternalValue();
        assertTrue(res);
        res = ((BoolValue)(it7.getValue(null).value)).getInternalValue();
        assertTrue(res);
        res = ((BoolValue)(it8.getValue(null).value)).getInternalValue();
        assertTrue(!res);
        res = ((BoolValue)(it9.getValue(new Environment(null, "testVal", new IntValue(4))).value)).getInternalValue();
        assertTrue(res);
    } // testGetValue()
}
