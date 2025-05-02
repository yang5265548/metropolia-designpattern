package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence sequence=new FibonacciSequence();
        Iterator<Integer> iterator=sequence.iterator();

        System.out.println("Fisrt 10 Fibonacci numbers:");
        for (int i = 0; i < 10 && iterator.hasNext(); i++) {
            System.out.print(iterator.next() + " ");
        }
    }
}
