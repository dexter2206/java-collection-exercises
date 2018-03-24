package zigzag;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Solution {

    public static void makeZigZag(List<Comparable> lst) {
        if(lst.size() <= 2) {
            return;
        }
        Comparable x, y;
        int order;
        ListIterator<Comparable> itFirst = lst.listIterator(), itSecond = lst.listIterator();
        itSecond.next();

        x = itFirst.next();
        y = itSecond.next();
        order = x.compareTo(y);

        while(itSecond.hasNext()) {
            x = itFirst.next();
            y = itSecond.next();
            if(x.compareTo(y) == order) {
                itFirst.set(y);
                itSecond.set(x);
            }
            order = -order;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3, 1, 5};
        List<Comparable> lst = Arrays.asList(arr);
        makeZigZag(lst);
        lst.stream().forEach(System.out::println);
    }
}
