package mainpack;

import expression.Expression;
import llvm.CodeGenerator;
import parser.Footle;
import parser.ParseException;
import staticpass.StaticPass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class main {

    public static void main(String[] args) {
        boolean emitLLVM = false;
        BufferedReader inStream = null;
        String fileName = null;
        Footle parser;
        Expression ast = null;
        StaticPass statPass = null;
        CodeGenerator llvmGen;
        
        if(args.length == 2 && args[0].equals("-emit-llvm"))
        {
            emitLLVM = true;
            //try opening args[1]
            try {
                fileName = args[1];
                inStream = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                System.out.println("compile: " + fileName + " not found.");
                System.exit(0);
            }
        }
        else if(args.length == 1)
        {
            //try opening args[0]
            try {
                fileName = args[0];
                if(fileName.equals("-emit-llvm"))
                {
                    System.out.println("compile: Input file required.");
                    System.out.println("Usage: compile [-emit-llvm] sourcefile");
                    System.exit(0);
                }
                inStream = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                System.out.println("compile: " + fileName + " not found.");
                System.exit(0);
            }
        }
        else
        {
            System.out.println("Usage: compile [-emit-llvm] sourcefile");
            System.exit(0);
        }

        if(inStream != null)
        {
            System.out.println("Parsing " + fileName + "...");
            parser = new Footle(inStream);
            try {
                ast = parser.Input();
                System.out.println("AST Generated: ");
                System.out.println(ast);
            } catch (ParseException e) {
                System.out.println("compile: Parse error encountered. Check input file.");
            }
        }
        if(ast != null)
        {
            System.out.println("\nRunning AST through static pass...");
            statPass = new StaticPass(ast);
            System.out.println("Static Pass Completed: ");
            System.out.println(statPass);
        }
        
        /*
        if(statPass != null)
        {
            System.out.println("Generating LLVM...");
            llvmGen = new CodeGenerator(statPass);
            //generate LLVM object tree from AST
            System.out.println("Outputting LLVM code to file...");
            //output LLVM to file
        }

        /*The following block is attributed to Bill Hess, borrowed from the Google Group
        if (Command.exec("llvm-as test.s -f") == 0)
            if (Command.exec("llvm-ld -o testbin test.s.bc") == 0)
                if (System.getProperty("os.name").contains("Windows"))
                    Command.exec("testbin.exe");
                else
                    Command.exec("testbin");
            else
                System.out.println("compile: Failed to create binary executable.");
        else
            System.out.println("compile: Assembler failed.");
        //End */

    }
}
