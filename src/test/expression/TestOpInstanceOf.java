package test.expression;

import expression.OpInstanceOf;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestOpInstanceOf {
    OpInstanceOf oio1;
    OpInstanceOf oio2;
    OpInstanceOf oio3;

    public TestOpInstanceOf() {
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
    public void testOpInstanceOf() {
        assertTrue((oio1!=null)&&(oio2!=null)&&(oio3!=null));
    } // testOpInstanceOf()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
