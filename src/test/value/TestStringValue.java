package test.value;

import value.StringValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestStringValue {
    private StringValue sv1;
    private StringValue sv2;
    private StringValue sv3;

    public TestStringValue() {
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
    public void testStringValue() {
        assertTrue((sv1!=null)&&(sv2!=null)&&(sv3!=null));
    } // testStringValue()

    @Test
    public void testGetInternalValue() {
        //TODO: write tests
    } // testGetInternalValue()

    @Test
    public void testIsType() {
        //TODO: write tests
    } // testIsType()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
