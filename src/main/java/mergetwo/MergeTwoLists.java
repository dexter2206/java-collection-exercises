package mergetwo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MergeTwoLists {

    public static <T extends Comparable> List<T> mergeLists(List<T> first, List<T> second) {
        List<T> result = new LinkedList<>();
        ListIterator<T> itFirst = first.listIterator(), itSecond = second.listIterator();

        T item1 = itFirst.hasNext() ? itFirst.next() : null;
        T item2 = itSecond.hasNext() ? itSecond.next(): null;

        while(item1 != null & item2 != null) {
            if(item1.compareTo(item2) <= 0) {
                result.add(item1);
                item1 = itFirst.hasNext() ? itFirst.next() : null;
            }
            else {
                result.add(item2);
                item2 = itSecond.hasNext() ? itSecond.next() : null;
            }
        }

        if(item1 != null) {
            result.add(item1);
        }
        if(item2 != null) {
            result.add(item2);
        }

        // at most only one of those will actually do something
        itFirst.forEachRemaining(result::add);
        itSecond.forEachRemaining(result::add);
        return result;
    }
}
