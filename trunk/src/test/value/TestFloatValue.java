package test.value;

import value.FloatValue;
        import org.junit.*;
        import static org.junit.Assert.*;

public class TestFloatValue {
    private FloatValue fv1;
    private FloatValue fv2;
    private FloatValue fv3;
    
    public TestFloatValue() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testFloatValue() {
        assertTrue((fv1!=null)&&(fv2!=null)&&(fv3!=null));
    } // testFloatValue()

    @Test
    public void testGetInternalValue() {
        //TODO: write tests
    } // testGetInternalValue()

    @Test
    public void testIsType() {
        //TODO: write tests
    } // testIsType()

    @Test
    public void testGetValue() {
        //TODO: write tests
    } // testGetValue()
}