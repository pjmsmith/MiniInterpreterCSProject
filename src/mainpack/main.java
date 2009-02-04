package mainpack;

import Interpreter.ReturnException;
import Interpreter.TypeException;
import Interpreter.UnboundIdentifierException;
import expression.Expression;
import expression.Sequence;
import llvm.CodeGenerator;
import parser.Footle;
import parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class main {

    public static void main(String[] args) {

        BufferedReader p = new BufferedReader(new InputStreamReader(System.in));
        String parserInput;
        Expression prog = new Sequence(null);
        CodeGenerator cg;
        Footle parser = null;
        boolean flag = false;

        System.out.println("Welcome to the Footle compiler temporary prompt!");
        do
        {
            System.out.println("Enter a sequence of statements to be parsed: ");
            try {
                cg = new CodeGenerator();
                parserInput = p.readLine();
                if(!flag)
                {
                    parser = new Footle(new StringReader(parserInput));
                    flag = true;
                }
                else
                {
                    parser.ReInit(new StringReader(parserInput));
                }
                prog = parser.Input();
                System.out.println("Parser generated AST: " + prog);
                //TODO: AST.toString();
                System.out.println("Static Checker...");
                //TODO: static checking
                cg.setIr(cg.generateCode(prog));
                System.out.println("LLVM IR Code generated: ");
                System.out.println(cg);
            } catch (IOException e) {
                System.exit(-1);
            } catch (UnboundIdentifierException e) {
                System.out.println("Unbound identifier, check input");
                System.exit(-1);
            } catch (ReturnException e) {
                System.out.println("Return exception, check return statement(s)");
                System.exit(-1);
            } catch (TypeException e) {
                System.out.println("Type exception, check types in statement(s)");
                System.exit(-1);
            } catch (ParseException e) {
                System.out.println("Parse exception encountered, check semi-colons, exiting");
                System.exit(-1);
            }
        } while(true);
    }

}
