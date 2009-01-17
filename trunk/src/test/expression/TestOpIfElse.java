package test.expression;

import expression.OpIfElse;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestOpIfElse {
    private OpIfElse oie1;
    private OpIfElse oie2;
    private OpIfElse oie3;

    public TestOpIfElse() {
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
    public void testOpIfElse() {
        assertTrue((oie1!=null)&&(oie2!=null)&&(oie3!=null));
    } // testOpIfElse()

    @Test
    public void testGetValue() {
        //TODO: write if else tests
    } // testGetValue()
}
