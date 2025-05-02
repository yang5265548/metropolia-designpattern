package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FibonacciSequence  implements Sequence{


    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }


}
