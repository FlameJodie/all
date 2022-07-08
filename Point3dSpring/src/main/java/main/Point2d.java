
package main;
import java.awt.Color;

public class Point2d extends Point3d{
private Color color=Color.BLACK;
    public Point2d(double x, double y, Color color) {
        super(x, y, 0);
        this.color=color;
    }
    public Point2d(double x, double y) {
        super(x, y, 0);
    }

    public Point2d() {
        super();
    }

    public Point2d(Point3d point) {
        super(point);
    }
    public void draw(){
    StdDraw.point(x, y);
    }
  
    public void move(double dx, double dy){
    this.x+=dx;
    this.y+=dy;
    }
   public void turn(double alpha){
    double dx = this.x*Math.cos(Math.toRadians(alpha))+this.y*Math.sin(Math.toRadians(alpha));
    double dy = this.x*Math.sin(Math.toRadians(alpha))- this.y*Math.cos(Math.toRadians(alpha));
    this.x=dx;
    this.y=dy;
    }

    @Override
    public String toString() {
        return String.format("(%.1f, %.1f)", super.x,super.y);
    }
   
}

