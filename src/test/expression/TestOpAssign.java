package test.expression;

import expression.OpAssign;
import expression.OpAdd;
import org.junit.*;
        import static org.junit.Assert.*;
import value.IdValue;
import value.IntValue;
import Interpreter.UnboundIdentifierException;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.Environment;

public class TestOpAssign {
    private OpAssign oass1;
    private OpAssign oass2;
    private OpAssign oass3;

    public TestOpAssign() {
    } // constructor

    @BeforeClass
    public static void unitSetup() {
    } // unitSetup()

    @AfterClass
    public static void unitCleanup() {
    } // unitCleanup()

    @Before
    public void methodSetup() {
        IdValue idval = new IdValue("testVal");
        IntValue i1 = new IntValue(4);
        OpAdd a1 = new OpAdd(i1, i1);

        oass1 = new OpAssign(idval, a1);
        oass2 = new OpAssign(idval, i1);
        oass3 = new OpAssign(idval, new IdValue("notFound"));
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpAssign() {
        assertTrue((oass1!=null)&&(oass2!=null)&&(oass3!=null));
    } // testOpAssign()

    @Test
    public void testGetValue() throws UnboundIdentifierException, ReturnException, TypeException {
        
    } // testGetValue()
}
