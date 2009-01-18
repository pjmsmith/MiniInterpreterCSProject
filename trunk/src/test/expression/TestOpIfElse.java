package test.expression;

import expression.*;
import org.junit.*;
        import static org.junit.Assert.*;
import value.IntValue;
import value.IdValue;
import value.FloatValue;

import java.util.List;
import java.util.ArrayList;

import Interpreter.Environment;
import Interpreter.UnboundIdentifierException;
import Interpreter.ReturnException;
import Interpreter.TypeException;

public class TestOpIfElse {
    private OpIfElse oie1;

    public TestOpIfElse() {
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
        IntValue i1 = new IntValue(3);
        List<Expression> seq = new ArrayList<Expression>();
        seq.add(new OpAdd(i1, idval));
        seq.add(new OpSub(i1, i1));
        List<Expression> seq2 = new ArrayList<Expression>();
        seq2.add(new OpAdd(i1, i1));
        Sequence s1 = new Sequence(seq);
        Sequence s2 = new Sequence(seq2);
        oie1 = new OpIfElse(new OpLessThan(new IntValue(3), new IdValue("testVal")), s1, s2);

        //if ( 3 < testVal )
        //then 3+idVal; 3-3
        //else 3+3
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testOpIfElse() {
        assertTrue(oie1!=null);
    } // testOpIfElse()

    @Test
    public void testGetValue() throws UnboundIdentifierException, ReturnException, TypeException {
      /*  int res = ((IntValue)(oie1.getValue(new Environment(null, "testVal", new IntValue(5)))).value).getInternalValue();
        assertEquals(res, 0);
        res = ((IntValue)(oie1.getValue(new Environment(null, "testVal", new IntValue(2)))).value).getInternalValue();
        assertEquals(res, 6);*/
    } // testGetValue()
}
