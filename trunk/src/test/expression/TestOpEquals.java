package test.expression;

import expression.OpEquals;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestOpEquals {
    OpEquals oe1;
    OpEquals oe2;
    OpEquals oe3;

    public TestOpEquals() {
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
    public void testOpEquals() {
        assertTrue((oe1!=null)&&(oe2!=null)&&(oe3!=null));
    } // testOpEquals()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
