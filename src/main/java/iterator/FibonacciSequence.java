package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FibonacciSequence  implements Sequence{
    private final int limit;

    public FibonacciSequence(int limit) {
        this.limit = limit;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }


}
