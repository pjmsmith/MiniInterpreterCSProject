default:
	javac ./src/*/*.java
	mv ./src/expression/*.class ./out/expression
	mv ./src/mainpack/*.class ./out/mainpack
	mv ./src/test/*.class ./out/test
	mv ./src/parser/*.class ./out/parser
	mv ./src/staticpass/*.class ./out/staticpass
	mv ./src/llvm/*.class ./out/llvm
	mv ./src/value/*.class ./out/value
	mv ./src/Interpreter/*.class ./out/Interpreter
	llvm-gcc -c -emit-llvm runner.c

clean:
	rm ./out/*/*.class
