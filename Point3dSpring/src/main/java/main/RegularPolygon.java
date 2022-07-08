package main;

import lombok.Getter;
import lombok.Setter;

import java.awt.Color;
import java.util.Objects;
import java.util.*;
@Setter
@Getter
public class RegularPolygon extends Shape implements IMove, IScale, ISwing {

    private Point2d center;
    private int n;
    private double radius;
    private double angle;

    public void setCenter(Point2d center) {
        this.center = center;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public RegularPolygon(Point2d p, int vertex, double radius) {
        this.center = new Point2d(p);
        this.n = vertex;
        this.radius = radius;
        this.angle = 0;
    }
    public RegularPolygon(double x ,double y, int vertex, double radius) {
        this.center = new Point2d(x, y);
        this.n = vertex;
        this.radius = radius;
        this.angle = 0;
    }




    public RegularPolygon() {
        this.center = new Point2d();
        this.n = 0;
        this.radius = 0;
        this.angle = 0;
    }

    public RegularPolygon(RegularPolygon p) {
        this.center = p.center;
        this.n = p.n;
        this.radius = p.radius;
        this.angle = p.angle;
    }

    @Override
    public void move(double dx, double dy) {
        this.center.x += dx;
        this.center.y += dy;
    }

    @Override
    public void resize(double value) {
        this.radius *= value;
    }

    @Override
    public double getWidth() {
        return this.radius * 2;
    }

    @Override
    public double getHeight() {
        return this.radius * 2;
    }

    public Point2d[] getVertexes() {
        double[] x = new double[this.n];
        double[] y = new double[this.n];
        Point2d[] verts = new Point2d[this.n];
        for (int i = 0; i < this.n; i++) {

            x[i] = this.center.x + this.radius * Math.cos(2 * Math.PI * i / this.n);
            y[i] = this.center.y + this.radius * Math.sin(2 * Math.PI * i / this.n);
            verts[i] = new Point2d(x[i], y[i]);
        }
        return verts;
    }
@Override
    public Point2d getCenter() {
       
//        double gx = 0, gy = 0, a = 0;
//          Point2d[] verts = new Point2d[this.n]; 
//                verts = this.getVertexes();
//        
//        for (int i = 0; i < this.n-1; i++) {
//            gx += (verts[i].getX() + verts[i + 1].getX()) * (verts[i].getX() * verts[i + 1].getY() - verts[i + 1].getX() * verts[i].getY());
//            gy += (verts[i].getY() + verts[i + 1].getY()) * (verts[i].getX() * verts[i + 1].getY() - verts[i + 1].getX() * verts[i].getY());
//            a += (verts[i].getX() * verts[i + 1].getY() - verts[i + 1].getX() * verts[i].getY());
//        }
//        a = a / 2;
//        gx = gx / 6 * a;
//        gy = gy / 6 * a;
//      
//        return new Point2d(gx, gy);
return this.center;
    }

    @Override
    public void turn(double alpha) {

        this.angle = alpha;
    }

    public void draw() {
        if (this.n == 0 || this.n == 1) {
            return;
        }
        this.turn(this.angle);
        double[] x = new double[this.n];
        double[] y = new double[this.n];

        Point2d[] verts = this.getVertexes();
        for (int i = 0; i < this.n; i++) {
            verts[i].turn(this.angle);
            x[i] = verts[i].getX();
            y[i] = verts[i].getY();
        }
        StdDraw.setPenColor(this.backgroundcolor);
        StdDraw.filledPolygon(x, y);
        StdDraw.setPenColor(this.color);
        StdDraw.polygon(x, y);
    }

    public double getArea() {

        return (Math.pow(this.radius,2) * this.n * Math.sin((Math.PI * 2) / this.n)) / 2;
    }

    public double getPerimetr() {

        return 2 * this.radius * this.n * Math.sin(Math.PI / this.n);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegularPolygon other = (RegularPolygon) obj;
        if (this.n != other.n) {
            return false;
        }
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        if (!Objects.equals(this.center, other.center)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Центр: %s;%nКоличество вершин: %d;%nРадиус:%f", this.center, this.n, this.radius);
    }

public void setX(double x){
        this.center.setX(x);

}

    public void setY(double y){
        this.center.setY(y);
    }
}
