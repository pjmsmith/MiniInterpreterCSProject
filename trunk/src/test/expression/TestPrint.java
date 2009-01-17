package test.expression;

import expression.Print;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestPrint {
    private Print p1;
    private Print p2;
    private Print p3;

    public TestPrint() {
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
    public void testPrint() {
        assertTrue((p1!=null)&&(p2!=null)&&(p3!=null));
    } // testPrint()

    @Test
    public void testGetValue() {
        //TODO: write print tests?
    } // testGetValue()
}
