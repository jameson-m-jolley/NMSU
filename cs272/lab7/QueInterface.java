public interface QueInterface<T> {
    public void inQue(T obj);
    public T next();
    public int size();
    public boolean isEmpty();
}
