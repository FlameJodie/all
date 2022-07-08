
package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.Color;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Test {
    
     public static void main(String[] args) {

         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

         StdDraw.setXscale(-10,10);
        StdDraw.setYscale(-10,10);
         RegularPolygon p = (RegularPolygon) context.getBean("poly1");
        p.setColor(Color.black);
        p.setBackgroundColor(Color.PINK);
        p.turn(90);
        p.resize(2);
        p.draw();
         RegularPolygon p1 = (RegularPolygon) context.getBean("poly2");
         p1.resize(0.5);
         p1.turn(270);
        p1.setBackgroundColor(Color.MAGENTA);
        p1.draw();

         RegularPolygon p2 = (RegularPolygon) context.getBean("poly3");
        p2.setBackgroundColor(Color.WHITE);
        p2.resize(0.5);
        p2.turn(90);
        p2.draw();
        p2.move(6, 6);
            p2.draw();
        
       System.out.println(p);
         System.out.println("width/height: "+p.getWidth()+" / "+p.getHeight());
         System.out.println("Baricenter: "+p.getCenter());
         System.out.println("Area: "+p.getArea());
         System.out.println("Perimetr: "+p.getPerimetr());
    }
}
