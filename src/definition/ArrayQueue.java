package definition;

import adt.CircularQueueArrayADT;

public class ArrayQueue<E> implements CircularQueueArrayADT<E> {
    static final int DEFAULT_CAPACITY = 10;
    int front = 0;
    int rear = -1;
    int size = 0;
    int capacity = 0;
    E[] data;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int intialCapacity) {
        this.capacity = intialCapacity;
        this.data = (E[]) new Object[this.capacity];  //
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    // add an item at the rear of the queue
    public boolean offer(E item) {
        if (size == capacity) {
            reallocateQueue();
        }
        size++;
        rear = (rear + 1) % capacity;
        data[rear] = item;
        return true;
    }

    // return an item from the front without removing it
    public E peek() {
        if (size == 0) {
            return null;
        } else {
            return data[front];
        }
    }

    // remove entry from front and return it
    public E poll() {
        if (size == 0) {
            return null;
        } else {
            E response = data[front];
            front = (front + 1) % capacity;
            size--;
            return response;
        }
    }

    public void reallocateQueue() {
        int newCapacity = this.capacity * 2;
        E[] newData = (E[]) new Object[newCapacity];
        int f = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
            f = (f + 1) % capacity;
        }
        front = 0;
        rear = size - 1;
        this.capacity = newCapacity;
        data = newData;
    }
}
