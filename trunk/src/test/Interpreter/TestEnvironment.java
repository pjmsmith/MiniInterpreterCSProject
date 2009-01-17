package test.Interpreter;

import Interpreter.Environment;
import Interpreter.UnboundIdentifierException;
import org.junit.*;
        import static org.junit.Assert.*;
import value.IntValue;
import value.FloatValue;
import value.IdValue;

public class TestEnvironment {
    private Environment e1;
    private Environment e2;
    private Environment e3;

    public TestEnvironment() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        e1 = new Environment(null, null, null);
        e2 = new Environment(null, "testVal", new IntValue(4));
        e3 = new Environment(e2, "topVal", new FloatValue((float)4.3));
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testEnvironment() {
        assertTrue((e1 != null) && (e2 != null) && (e3 != null));
    } // testEnvironment()

    @Test
    public void testFindIDInList() {
        Environment t = Environment.findIDInList("testVal", e3);
        assertTrue(t!=null);
    } // testFindIDInList()

    @Test
    public void testFindID() {
        assertTrue(e2.findID("testVal")==e2);
        assertTrue(e1.findID("fail")==null);
    } // testFindID()

    @Test
    public void testCheckForID() throws UnboundIdentifierException {
        assertTrue(Environment.checkForID(new IdValue("testVal"), e3)!=null);
    } // testCheckForID()
}
