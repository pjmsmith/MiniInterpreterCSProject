package test.value;

import value.IdValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestIdValue {
    private IdValue idv1;

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
        idv1 = new IdValue("testVal");
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testIdValue() {
        assertTrue(idv1!=null);
    } // testIdValue()

    @Test
    public void testGetInternalValue() {
        assertEquals("testVal", idv1.getInternalValue());
    } // testGetInternalValue()

    @Test
    public void testGetValue() {
        assertTrue(idv1.getValue(null)!=null);
    } // testGetValue()

    @Test
    public void testIsType() {
        assertTrue(idv1.isType(idv1));
    } // testIsType()
}
