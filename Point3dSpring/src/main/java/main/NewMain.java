//
//package main;
//
//import java.util.*;
//
//
//public class NewMain {
//
//
//    public static void main(String[] args) {
//       Scanner in = new Scanner (System.in);
//        System.out.println("Введите точку A");
//        Point3d A=new Point3d(in.nextDouble(),in.nextDouble(),in.nextDouble());
//         System.out.println("Введите точку B");
//         Point3d B=new Point3d(in.nextDouble(),in.nextDouble(),in.nextDouble());
//          System.out.println("Введите точку C");
//          Point3d C=new Point3d(in.nextDouble(),in.nextDouble(),in.nextDouble());
//
//          System.out.println("Первая точка "+A);
//          System.out.println("Первая точка "+B);
//          System.out.println("Первая точка "+C);
//
//          System.out.println(isTriangle(A,B,C));
//          System.out.println("Площадь треугольника "+computeArea(A,B,C));
//
//    }
//
//    public static boolean isTriangle( Point3d A, Point3d B, Point3d C){
//
//   if (A.getEuclideanDistanceTo(C) <= A.getEuclideanDistanceTo(B)+B.getEuclideanDistanceTo(C)||
//           (A.getEuclideanDistanceTo(B) <= A.getEuclideanDistanceTo(C)+B.getEuclideanDistanceTo(C)) ||
//          (B.getEuclideanDistanceTo(C) <= A.getEuclideanDistanceTo(B)+A.getEuclideanDistanceTo(C))) return true;
// return false;
//    }
//
//
//    public static double computeArea(Point3d A, Point3d B, Point3d C){
//    if (!isTriangle(A,B,C)) return -1;
//     double p = (A.getEuclideanDistanceTo(B)+A.getEuclideanDistanceTo(C)+B.getEuclideanDistanceTo(C))/2;
//    double area = Math.sqrt(p*(p-A.getEuclideanDistanceTo(B))*(p-A.getEuclideanDistanceTo(C))*(p-B.getEuclideanDistanceTo(C)));
//    return area;
//    }
//}
