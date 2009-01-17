package test.expression;

import expression.Return;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestReturn {
    private Return r1;
    private Return r2;
    private Return r3;

    public TestReturn() {
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
    public void testReturn() {
        assertTrue((r1!=null)&&(r2!=null)&&(r3!=null));
    } // testReturn()

    @Test
    public void testGetValue() {
        //TODO: write return tests
    } // testGetValue()
}
