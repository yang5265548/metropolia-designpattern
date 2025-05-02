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



    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {

        int result = curr;
        int next = prev + curr;
        prev = curr;
        curr = next;
        return result;
    }
}
