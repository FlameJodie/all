
package main;


public interface IOperation {
    boolean contains(IOperation other);
    IOperation getUnion(IOperation other);
    IOperation getIntersection(IOperation other);
}
