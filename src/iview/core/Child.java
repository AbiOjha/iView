package iview.core;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/23/13
 * Time: 12:25 PM
 */
public class Child extends Base {
    private String str = "Initialization";

    static {
        System.out.println("Child Sratic");

    }

    public Child() {
        super();
        System.out.println("Child Constructor");
        System.out.println(str);
    }

    public static void main(String[] args) {
        Child ch = new Child();
        //Child ch1 = new Child();

    }
}
