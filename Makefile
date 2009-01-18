CLASSES:
    ./expression/*.java
    ./Interpreter/*.java
    ./mainpack/*.java
    ./value/*.java
    ./test/*.java
    ./test/expression/*.java
    ./test/Interpreter/*.java
    ./test/value/*.java

all:
    javac $(CLASSES)
