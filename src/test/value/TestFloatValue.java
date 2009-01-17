package test.value;

import value.FloatValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestFloatValue {
    private FloatValue fv1;
    
    public TestFloatValue() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        fv1 = new FloatValue((float)4.3);
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testFloatValue() {
        assertTrue(fv1!=null);
    } // testFloatValue()

    @Test
    public void testGetInternalValue() {
        assertEquals(4.3, fv1.getInternalValue());
    } // testGetInternalValue()

    @Test
    public void testIsType() {
        assertTrue(fv1.isType(fv1));
    } // testIsType()

    @Test
    public void testGetValue() {
        assertTrue(fv1.getValue(null)!=null);
    } // testGetValue()
}
