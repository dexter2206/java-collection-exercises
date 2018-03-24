package mergek;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MergeKLists {



    public static <T extends Comparable> List<T> mergeLists(List<List<T>> lists) {
        PriorityQueue<T> queue = new PriorityQueue<>();
        lists.stream().forEach(list -> list.stream().forEach(queue::offer));
        List<T> result = new LinkedList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}
