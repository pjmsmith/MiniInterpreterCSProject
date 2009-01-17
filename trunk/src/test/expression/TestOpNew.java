package test.expression;

import expression.OpNew;
        import org.junit.*;
        import static org.junit.Assert.*;


public class TestOpNew {
    OpNew on1;
    OpNew on2;
    OpNew on3;

    public TestOpNew() {
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
    public void testOpNew() {
        assertTrue((on1!=null)&&(on2!=null)&&(on3!=null));
    } // testOpNew()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
