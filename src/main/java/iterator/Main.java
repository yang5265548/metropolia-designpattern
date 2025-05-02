package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence sequence=new FibonacciSequence(10);
        Iterator<Integer> iterator=sequence.iterator();

        System.out.println("Fisrt 10 Fibonacci numbers:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
