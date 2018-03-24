package mergetwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionTest {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 3, 6, 9, 11};
        Integer[] arr2 = new Integer[] {2, 4};
        List<Integer> l = new ArrayList<>(Arrays.asList(arr));
        List<Integer> r = new ArrayList<>(Arrays.asList(arr2));

        MergeTwoLists.mergeLists(l, r).stream().forEach(System.out::println);

    }
}
