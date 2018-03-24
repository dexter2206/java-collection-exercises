package mergek;

import mergetwo.MergeTwoLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKTest {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 3, 6, 9, 11};
        Integer[] arr2 = new Integer[]{2, 4};
        Integer[] arr3 = new Integer[]{-1, 12};
        List<Integer> l = new ArrayList<>(Arrays.asList(arr));
        List<Integer> r = new ArrayList<>(Arrays.asList(arr2));
        List<Integer> q = new ArrayList<>(Arrays.asList(arr3));
        List<List<Integer>> lst = Arrays.asList(l, r, q);
        MergeKLists.mergeLists(lst).stream().forEach(System.out::println);
    }
}
