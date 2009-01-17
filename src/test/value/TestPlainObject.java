package test.value;

import value.PlainObject;
import value.IntValue;
import value.BoolValue;
import org.junit.*;
        import static org.junit.Assert.*;
import Interpreter.UnboundIdentifierException;
import Interpreter.ReturnException;
import Interpreter.TypeException;

public class TestPlainObject {
    PlainObject po1;

    public TestPlainObject() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        po1 = new PlainObject();

    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testPlainObject() {
        assertTrue(po1!=null);
    } // testPlainObject()

    @Test
    public void testIsType() {
        assertTrue(po1.isType(po1));
    } // testIsType()

    @Test
    public void testGetValue() throws UnboundIdentifierException, ReturnException, TypeException {
        assertTrue(po1.getValue(null)!=null);
    } // testGetValue()

    @Test
    public void testObjectMethods() {
        po1.addField("a", new IntValue(3));
        po1.addField("b", new BoolValue(false));
        assertTrue(po1.getField("a")!=null);
        assertTrue(po1.doesFieldExist("b"));
    }
}
