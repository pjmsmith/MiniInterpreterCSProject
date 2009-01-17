package test.value;

import value.Function;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestFunction {
    private Function f1;
    private Function f2;
    private Function f3;

    public TestFunction() {
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
    public void testFunction() {
        assertTrue((f1!=null)&&(f2!=null)&&(f3!=null));
    } // testFunction()

    @Test
    public void testGetParamList() {
        //TODO: write tests
    } // testGetParamList()

    @Test
    public void testIsType() {
        //TODO: write tests
    } // testIsType()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
