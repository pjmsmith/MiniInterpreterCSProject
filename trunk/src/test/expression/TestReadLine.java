package test.expression;

import expression.ReadLine;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestReadLine {
    ReadLine rl1;
    ReadLine rl2;
    ReadLine rl3;

    public TestReadLine() {
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
    public void testReadLine() {
        assert((rl1!=null)&&(rl2!=null)&&(rl3!=null));
    } // testReadLine()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
