
package main;
import java.awt.Color;

abstract class Shape {
protected Color color = Color.BLACK;
protected Color backgroundcolor = Color.WHITE;
   
public abstract double getPerimetr();
public abstract double getArea();
public abstract void draw();

public void setColor(Color c){
this.color=c;
}
public void setBackgroundColor(Color c){
this.backgroundcolor=c;
}

}
