package adt;

public interface CircularQueueArrayADT<E> {

    boolean offer(E item);
    E peek();
    E poll();
    void reallocateQueue();
}
