package linkedlist;

public class TestMyList {

    public static void main(String[] args) {
        MyList l = new MyList();
        l.add(5);
        l.add(-1);
        l.add(10);
        l.add(-5);
        l.remove(new Integer(-5));
        System.out.println(l);
        l.add(20);
        System.out.println(l);
    }
}
