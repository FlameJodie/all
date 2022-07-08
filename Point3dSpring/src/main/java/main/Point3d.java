
package main;


public class Point3d {

    protected double x;
    protected double y;
    private double z;
   
    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
}
    public Point3d() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
      
    }
    public Point3d(Point3d point){
   this.x=point.getX();
   this.y=point.getY();
   this.z=point.getZ();
    }
    
 public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getZ() {
        return this.z;
    }
public void setX(double value) {
        this.x = value;
    }

    public void setY(double value) {
        this.y = value;
    }

     public void setZ(double value) {
        this.y = value;
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
        final Point3d other = (Point3d) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        return true;
    }
     
     
     
     public double getEuclideanDistanceTo(Point3d point){
     
      double dis = Math.sqrt(Math.pow((this.x-point.getX()), 2)+(Math.pow((this.y-point.getY()), 2))+(Math.pow((this.z-point.getZ()), 2)));
         return dis;
     }
     
     public double getManhattanDistanceTo(Point3d point){
     
         double dis = Math.abs(this.x-point.getX())+ Math.abs(this.y-point.getY())+Math.abs(this.z-point.getZ());
         return dis;
         
     }
     public String toString(){
     
   
   return String.format("(%.5f; %.5f; %.5f)", this.x, this.y, this.z);
     }
}
