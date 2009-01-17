package test.value;

import value.ClosureValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestClosureValue {
    private ClosureValue cv1;
    private ClosureValue cv2;
    private ClosureValue cv3;

    public TestClosureValue() {
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
    public void testClosureValue() {
        assertTrue((cv1!=null)&&(cv2!=null)&&(cv3!=null));
    } // testClosureValue()

    @Test
    public void testSetEnvironment() {
        //TODO: write tests
    } // testSetEnvironment()

    @Test
    public void testGetEnvironment() {
        //TODO: write tests
    } // testGetEnvironment()

    @Test
    public void testGetIntFunc() {
        //TODO: write tests
    } // testGetIntFunc()

    @Test
    public void testIsType() {
        //TODO: write tests
    } // testIsType()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
