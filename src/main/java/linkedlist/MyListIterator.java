package linkedlist;

import java.util.Iterator;

public class MyListIterator implements Iterator<Integer> {

    private ListNode current;

    public MyListIterator(ListNode first) {
        current = first;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Integer next() {
        Integer val = current.getValue();
        current = current.getNext();
        return val;
    }
}
