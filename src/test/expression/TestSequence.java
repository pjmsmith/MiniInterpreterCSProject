package test.expression;

import expression.Sequence;
import expression.Expression;
import expression.OpAdd;
import expression.OpSub;
import org.junit.*;
        import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import value.IntValue;
import value.IdValue;
import value.VoidValue;
import value.Value;
import Interpreter.UnboundIdentifierException;
import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.Environment;

public class TestSequence {
    private Sequence s1;
    private Sequence s2;

    public TestSequence() {
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
        s1 = new Sequence(seq);
        s2 = new Sequence(new ArrayList<Expression>());
    } // methodSetup()

    @After
    public void methodCleanup() {
    } // methodCleanup()

    @Test
    public void testSequence() {
        assertTrue((s1!=null)&&(s2!=null));
    } // testSequence()

    @Test
    public void testGetValue() throws UnboundIdentifierException, ReturnException, TypeException {
        int i = ((IntValue)(s1.getValue(new Environment(null, "testVal", new IntValue(5))).value)).getInternalValue();
        assertEquals(i, 0);
        Value v = s2.getValue(null).value;
        assertTrue((v instanceof VoidValue));
    } // testGetValue()
}
