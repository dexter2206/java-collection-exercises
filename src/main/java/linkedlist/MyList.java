package linkedlist;

import java.util.Iterator;

public class MyList implements Iterable<Integer> {

    private ListNode first, last;
    private int count;

    public MyList() {
        count = 0;
    }

    public void add(Integer value) {
        ListNode newNode = new ListNode(value);
        if(first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        count += 1;
    }

    public Integer get(int i) {
        return findNode(i).getValue();
    }

    public void set(int i, Integer value) {
        findNode(i).setValue(value);
    }

    public boolean contains(Integer value) {
        ListNode node = first;
        while(node != null) {
            if(node.getValue().equals(value)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public int size() {
        return count;
    }

    public void remove(int index) {
        if(size() == 0) {
            throw new IndexOutOfBoundsException("Usuwanie z pustej listy!");
        }
        if(index >= size()) {
            throw new IndexOutOfBoundsException("Index poza zakresem!");
        }
        if(index == 0) {
            first = first.getNext();
        } else {
            ListNode node = findNode(index - 1);
            node.setNext(node.getNext().getNext());
            if(index == size() - 1) {
                last = node;
            }
        }
        count -= 1;
    }

    public boolean remove(Object o) {
        if(first == null) {
            return false;
        }
        if(first.getValue().equals(o)) {
            first = first.getNext();
            count -= 1;
            return true;
        }
        ListNode node = first;
        while(node.getNext() != null) {
            if(node.getNext().getValue().equals(o)) {
                if(node.getNext() == last) {
                    last = node;
                }
                node.setNext(node.getNext().getNext());
                count -= 1;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    private ListNode findNode(int i) {
        if(i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException(
                    "Niepoprawny index: " + Integer.toString(i));
        }
        ListNode node = first;
        for(int j = 0; j < i; j++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public String toString() {
        if(first == null) {
            return "pusta lista";
        }
        ListNode node = first;
        String s = "";
        while(node != null) {
            s += node.getValue() + " ";
            node = node.getNext();
        }
        return s;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyListIterator(first);
    }
}
