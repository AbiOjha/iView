package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/12/13
 * Time: 11:48 PM
 */
public class ReverseNumbers {
    public static void main(String[] args) {
        Integer[] values = {1, 4, 6, 7, 8, 9};
        Deque<Integer> numberStack = new ArrayDeque<Integer>(10);

        for (int i=0; i < values.length; i++){
            numberStack.push(values[i]);
        }

        Integer[] valuesReversed = new Integer[values.length];

        int i = 0;
        while(!numberStack.isEmpty()){
            valuesReversed[i++] = numberStack.pop();
        }

        System.out.println(Arrays.deepToString(valuesReversed));
    }
}
