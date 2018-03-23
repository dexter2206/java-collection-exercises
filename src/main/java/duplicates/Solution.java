package duplicates;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {

    public static <T> void removeDuplicates(List<T> list) {
        Iterator<T> iterator = list.iterator();
        Set<T> seen = new HashSet<>();

        while(iterator.hasNext()) {
            if(seen.add(iterator.next())) {
                iterator.remove();
            }
        }
    }
}
