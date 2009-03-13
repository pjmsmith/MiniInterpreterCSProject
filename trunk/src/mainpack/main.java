package mainpack;

import expression.Expression;
import llvm.CodeGenerator;
import parser.Footle;
import parser.ParseException;
import staticpass.StaticPass;

import java.io.*;

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
            //System.out.println("Parsing " + fileName + "...");
            parser = new Footle(inStream);
            try {
                ast = parser.Input();
                //System.out.println("AST Generated: ");
                //System.out.println(ast);
            } catch (ParseException e) {
                System.out.println("compile: Parse error encountered. Check input file.");
            }
        }
        if(ast != null)
        {
            //System.out.println("\nRunning AST through static pass...");
            statPass = new StaticPass(ast);
            statPass.runStaticPass();
            //System.out.println("Static Pass Completed: ");
            //System.out.println(statPass);
        }

        //generate the llvm from the result of the static pass
        if(statPass != null)
        {
            //System.out.println("Generating LLVM...");
            llvmGen = new CodeGenerator(statPass);
            //System.out.println("***CodeGenerated***");
            //System.out.println(llvmGen);
            //generate LLVM object tree from AST
            //System.out.println("Outputting LLVM code to file...");
            //output LLVM to file
            toLLVMFile(llvmGen.toString());
            
        }
        //run assemble and run the llvm code
        //The following block is attributed to Bill Hess, borrowed from the Google Group
        if(emitLLVM)
        {
            if (System.getProperty("os.name").contains("Windows"))
            {
                        System.exit(-1);
            }
            if (Command.exec("llvm-as -f out/my-footle.s ") == 0)
                if (Command.exec("llvm-ld -o a.out out/my-footle.s.bc runner.o") == 0)
                {
                    //do nothing
                }
                else
                    System.out.println("compile: Failed to create binary executable.");
            else
                System.out.println("compile: Assembler failed.");
            //End
        }
        else
        {
            System.out.println("compile: SPARC generation not supported!");
        }

    }

    public static void toLLVMFile(String ir)
    {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("my-footle.s"));
            out.write(ir);
            out.close();
        } catch (IOException e) {
            System.out.println("Could not write to file.");
            System.exit(-1);
        }
    }

}
