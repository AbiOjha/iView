package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/12/13
 * Time: 10:19 PM
 */
public class EvaluateTest {
    Evaluate eval = null;

    @Before
    public void setUp(){
        eval = new Evaluate();
    }

    @Test
    public void testPositiveIsBalanced(){
        boolean result = eval.isBalanced("public static void main(String[] args){}");
        Assert.assertTrue(result);
    }

    @Test
    public void testNegativeBalanced(){
        boolean result = eval.isBalanced("public static void main(String[ args) {}");   // missing ']'
        Assert.assertFalse(result);

        result = eval.isBalanced("public static void main(String[] args) }");          // missing '{'
        Assert.assertFalse(result);


        result = eval.isBalanced("public static void main String[] args) {}");        // missing '('
        Assert.assertFalse(result);
    }
}
