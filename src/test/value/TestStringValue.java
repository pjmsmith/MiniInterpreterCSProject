package test.value;

import value.StringValue;
import value.IntValue;
import org.junit.*;
        import static org.junit.Assert.*;

public class TestStringValue {
    private StringValue sv1;

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
        sv1 = new StringValue("testVal");
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testStringValue() {
        assertTrue(sv1!=null);
    } // testStringValue()

    @Test
    public void testGetInternalValue() {
        assertEquals("testVal", sv1.getInternalValue());
    } // testGetInternalValue()

    @Test
    public void testIsType() {
        assertTrue(sv1.isType(sv1));
    } // testIsType()

    @Test
    public void testGetValue() {
        assertTrue(sv1.getValue(null)!=null);
    } // testGetValue()

    @Test
    public void testObjectMethods() {
        sv1.addField("length", new IntValue(7));
        assertTrue(sv1.doesFieldExist("length"));
        assertTrue((sv1.getField("length"))!=null);
    }
}
