/**
 * Created by vitaly on 14.04.16.
 */
public class Digit{
    char symbol;
    int line;
    int column;

    public Digit(char symbol, int line, int column) {
        this.symbol = symbol;
        this.line = line;
        this.column = column;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}