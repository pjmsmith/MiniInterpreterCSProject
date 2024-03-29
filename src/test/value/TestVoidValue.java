package test.value;

import value.VoidValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestVoidValue {
    private VoidValue vv1;

    public TestVoidValue() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        vv1 = new VoidValue();
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testVoidValue() {
        assertTrue(vv1!=null);
    } // testVoidValue()

    @Test
    public void testIsType() {
        assertTrue(vv1.isType(vv1));
    } // testIsType()

    @Test
    public void testGetValue() {
        assertTrue(vv1.getValue(null)!=null);
    } // testGetValue()
}
