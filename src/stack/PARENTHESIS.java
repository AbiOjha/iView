package stack;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/12/13
 * Time: 10:06 PM
 */
public enum PARENTHESIS {
    LP('('), RP(')'), LB('{'), RB('}'), LSB('['), RSB(']');

    final char symbol;

    private PARENTHESIS(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
