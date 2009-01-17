package test.value;

import value.PlainObject;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestPlainObject {
    PlainObject po1;
    PlainObject po2;
    PlainObject po3;

    public TestPlainObject() {
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
    public void testPlainObject() {
        assertTrue((po1!=null)&&(po2!=null)&&(po3!=null));
    } // testPlainObject()

    @Test
    public void testIsType() {
        //TODO: write tests
    } // testIsType()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}
