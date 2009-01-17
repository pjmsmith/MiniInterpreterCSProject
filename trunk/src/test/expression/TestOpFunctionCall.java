package test.expression;

import expression.OpFunctionCall;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestOpFunctionCall {
    private OpFunctionCall ofc1;
    private OpFunctionCall ofc2;
    private OpFunctionCall ofc3;

    public TestOpFunctionCall() {
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
    public void testOpFunctionCall() {
        assertTrue((ofc1!=null)&&(ofc2!=null)&&(ofc3!=null));
    } // testOpFunctionCall()

    @Test
    public void testGetValue() {
        //TODO: write function call tests
    } // testGetValue()
}
