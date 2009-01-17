package test.value;

import value.BoolValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestBoolValue {
    private BoolValue bv1;
    private BoolValue bv2;

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
        bv1 = new BoolValue(true);
        bv2 = new BoolValue(false);
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testBoolValue() {
        assertTrue((bv1!=null)&&(bv2!=null));
    } // testBoolValue()

    @Test
    public void testGetInternalValue() {
        assertEquals(true, bv1.getInternalValue());
        assertEquals(false, bv2.getInternalValue());
    } // testGetInternalValue()

    @Test
    public void testGetValue() {
        assertTrue(bv1.getValue(null)!=null);
    } // testGetValue()

    @Test
    public void testIsType() {
        assertTrue(bv2.isType(bv2));
    } // testIsType()
}
