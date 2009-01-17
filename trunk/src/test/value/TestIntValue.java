package test.value;

import value.IntValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestIntValue {
    private IntValue iv1;

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
        iv1 = new IntValue(3);
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testIntValue() {
        assertTrue(iv1!=null);
    } // testIntValue()

    @Test
    public void testGetInternalValue() {
        assertEquals(3, iv1.getInternalValue());
    } // testGetInternalValue()

    @Test
    public void testIsType() {
        assertTrue(iv1.isType(iv1));
    } // testIsType()

    @Test
    public void testGetValue() {
        assertTrue(iv1.getValue(null)!=null);
    } // testGetValue()
}
