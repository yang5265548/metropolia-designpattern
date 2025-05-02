package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * The FibonacciIterator holds the full state of the sequence.
 * This ensures each iterator is independent.
 * Although the sequence could generate values, keeping state here
 * follows the standard Iterator pattern more closely.
 */

public class FibonacciIterator implements Iterator<Integer> {
    private int prev=0;
    private int curr=1;
    private int count=0;
    private final int limit;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }



    @Override
    public boolean hasNext() {
        return count<limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more Fibonacci numbers.");
        }

        int result = curr;
        int next = prev + curr;
        prev = curr;
        curr = next;
        count++;
        return result;
    }
}
