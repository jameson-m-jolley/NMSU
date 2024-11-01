interface StackInterface<T> {
    /*Q1. (2.5 pts) Write a generic interface for stack and put the code in StackInterface.java. This interface should
include five functions: push, pop, top, size, and isEmpty. */
    public void push(T data);
    public T pop();
    public T top();
    public int size();
    public boolean isEmpty();
}
