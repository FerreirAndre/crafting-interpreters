javac -d out src/com/craftinginterpreters/lox/*.java

if [[ $# -eq 1 ]]; then
        java -cp out com/craftinginterpreters.lox.Lox $1
else
        java -cp out com/craftinginterpreters.lox.Lox 
fi

