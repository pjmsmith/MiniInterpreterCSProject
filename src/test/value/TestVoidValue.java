package test.value;

import value.VoidValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestVoidValue {
    private VoidValue vv1;
    private VoidValue vv2;
    private VoidValue vv3;

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
        //TODO: set up fixture
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testVoidValue() {
        assertTrue((vv1!=null)&&(vv2!=null)&&(vv3!=null));
    } // testVoidValue()

    @Test
    public void testIsType() {
        //TODO: write tests
    } // testIsType()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
