package test.expression;

import expression.*;
import org.junit.*;
        import static org.junit.Assert.*;
import value.BoolValue;
import value.IntValue;
import value.IdValue;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

import Interpreter.Environment;
import Interpreter.UnboundIdentifierException;
import Interpreter.ReturnException;
import Interpreter.TypeException;

public class TestOpWhile {
    private OpWhile ow1;
    private OpWhile ow2;
    private OpWhile ow3;

    public TestOpWhile() {
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
        BoolValue b1 = new BoolValue(false);
        IntValue i1 = new IntValue(3);
        OpLessThan olt1 = new OpLessThan(idval, new IntValue(8));
        List<Expression> seql = new ArrayList<Expression>();
        seql.add(new OpAssign(idval, new OpAdd(idval, new IntValue(1))));
        seql.add(new OpSub(i1, i1));
        Sequence s1 = new Sequence(seql);
        Sequence s2 = new Sequence(new ArrayList<Expression>());
        ow1 = new OpWhile(b1, s2);
        ow2 = new OpWhile(olt1, s1);
        ow3 = new OpWhile(i1, s1);
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpWhile() {
        assertTrue((ow1!=null)&&(ow2!=null)&&(ow3!=null));
    } // testOpWhile()

    @Test
    public void testGetValue() throws UnboundIdentifierException, ReturnException, TypeException {
       /* Environment res1 = ow1.getValue(new Environment(null, "testVal", new IntValue(5)));
        assertTrue((res1!=null));
        Environment res2 = ow2.getValue(new Environment(null, "testVal", new IntValue(5)));
        assertTrue((res2!=null));  */
        //TODO: fix
    } // testGetValue()
}
