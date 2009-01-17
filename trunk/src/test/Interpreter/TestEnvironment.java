package test.Interpreter;

import Interpreter.Environment;
        import org.junit.*;
        import static org.junit.Assert.*;

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
        //TODO: set up fixture
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testEnvironment() {
        assertTrue((e1!=null)&&(e2!=null)&&(e3!=null));
    } // testEnvironment()

    @Test
    public void testFindIDInList() {
        //TODO: write test
    } // testFindIDInList()

    @Test
    public void testFindID() {
        //TODO: write test
    } // testFindID()
}
