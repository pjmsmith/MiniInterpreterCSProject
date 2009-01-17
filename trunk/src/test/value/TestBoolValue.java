package test.value;

import value.BoolValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestBoolValue {
    private BoolValue bv1;
    private BoolValue bv2;
    private BoolValue bv3;

    public TestBoolValue() {
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
    public void testBoolValue() {
        assertTrue((bv1!=null)&&(bv2!=null)&&(bv3!=null));
    } // testBoolValue()

    @Test
    public void testGetInternalValue() {
        //TODO: write tests
    } // testGetInternalValue()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()

    @Test
    public void testIsType() {
        fail(); // @todo - implement
    } // testIsType()
}
