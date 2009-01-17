package test.expression;

import expression.SubString;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestSubString {
    SubString ss1;
    SubString ss2;
    SubString ss3;

    public TestSubString() {
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
    public void testSubString() {
        assertTrue((ss1!=null)&&(ss2!=null)&&(ss3!=null));
    } // testSubString()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
