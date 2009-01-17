package test.value;

import value.IntValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestIntValue {
    private IntValue iv1;
    private IntValue iv2;
    private IntValue iv3;

    public TestIntValue() {
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
    public void testIntValue() {
        assertTrue((iv1!=null)&&(iv2!=null)&&(iv3!=null));
    } // testIntValue()

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
