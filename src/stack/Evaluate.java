package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/12/13
 * Time: 10:08 PM
 */
public class Evaluate {
    // stack to store parenthesis
    final Deque<Character> stack = new ArrayDeque<Character>();

    public boolean isBalanced(String s) {
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == PARENTHESIS.LB.getSymbol()
                    || ch == PARENTHESIS.LP.getSymbol()
                    || ch == PARENTHESIS.LSB.getSymbol())
                // push the opening bracket
            stack.push(ch); // autoboxing

            // for RHS check is there is a matching LHS parenthesis
            else if (ch == PARENTHESIS.RP.getSymbol()){
                if (stack.isEmpty() || stack.pop() != PARENTHESIS.LP.getSymbol())
                    return false;
            } else if (ch == PARENTHESIS.RB.getSymbol()){
                if (stack.isEmpty() || stack.pop() != PARENTHESIS.LB.getSymbol())
                    return false;
            }else if (ch == PARENTHESIS.RSB.getSymbol()){
                if (stack.isEmpty() || stack.pop() != PARENTHESIS.LSB.getSymbol())
                    return false;
            }

        }
        return stack.isEmpty();
    }
}
