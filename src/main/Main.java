package main;

import definition.ArrayQueue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> obj = new ArrayQueue<>();
        obj.offer(5);
        obj.offer(7);
        obj.offer(8);
        obj.offer(9);
        int a = obj.peek();
        System.out.println(a);

    }
}
