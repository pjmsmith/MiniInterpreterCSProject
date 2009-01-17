package test.value;

import value.IdValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestIdValue {
    private IdValue idv1;
    private IdValue idv2;
    private IdValue idv3;

    public TestIdValue() {
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
    public void testIdValue() {
        assertTrue((idv1!=null)&&(idv2!=null)&&(idv3!=null));
    } // testIdValue()

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
        //TODO: write tests
    } // testIsType()
}
