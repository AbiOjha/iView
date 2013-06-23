package spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/23/13
 * Time: 12:22 PM
 */
public class DrawingApp {

    public static void main(String[] args) {
        //Triangle triangle = new Triangle();
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        //triangle.draw();

    }
}
