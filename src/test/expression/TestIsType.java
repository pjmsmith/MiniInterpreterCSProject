package test.expression;

import expression.IsType;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestIsType {
    IsType it1;
    IsType it2;
    IsType it3;

    public TestIsType() {
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
    public void testIsType() {
        assertTrue((it1!=null)&&(it2!=null)&&(it3!=null));
    } // testIsType()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
