
package main;

import java.util.*;


public class RandomPoints {

   
    public static void main(String[] args) {
       Scanner in = new Scanner (System.in);
       int n = in.nextInt(), count = 0, mini=0, minj=0;
       double d=in.nextDouble(), min=Double.MAX_VALUE, dist=0;
       
       Point3d[] points =  new Point3d[n];
       randompoints(points);
       //printarray(points);
        
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                
                dist=points[i].getEuclideanDistanceTo(points[j]);
            if (dist<d){
                count++;
            if (dist<min){
                min=dist;
            mini=i;
            minj=j;}
                
            }
            
            }
            
        }
          System.out.println("Количество точек с расстоянием меньше d "+count);
            System.out.printf("Ближайшие точки points[%d]= "+points[mini]+" и points[%d]= "+points[minj], mini, minj);
            System.out.println("расстояние между ближайшими точками"+" "+min);
          
          }
          public static void printarray (Point3d[] a){
          for (int i=0;i<a.length;i++)
                  System.out.println(a[i]);
          
          }
          
        public static Point3d[] randompoints(Point3d[] a){
        
            for (int i=0; i<a.length;i++){
            a[i]=new Point3d(Math.random(), Math.random(), Math.random());
            }
            return a;
            
        }
    
    
    public static Point3d computeCenterOfMass (Point3d[] a){
        double cX=0, cY=0, cZ=0;
    for(int i=0;i<a.length;i++){
        cX+=a[i].getX();
        cY+=a[i].getY();
        cZ+=a[i].getZ();
    }
    cX=cX/a.length;
    cY=cY/a.length;
    cZ=cZ/a.length;
    
    return  new Point3d(cX, cY, cZ);
    }
}
