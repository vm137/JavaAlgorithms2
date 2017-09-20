import java.lang.Iterable;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first = null, last = null;
    private int N = 0;

    private class Node {
        Item item;
        Node next = null;
        Node prev = null;
    }

    // construct an empty deque
    public Deque() {}

    // add the item to the front
    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (oldFirst != null) {
            first.next = oldFirst;
            oldFirst.prev = first;
        } else {
            last = first;
        }
        N++;
    }

    // add the item to the end
    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (oldLast != null) {
            last.prev = oldLast;
            oldLast.next = last;
        } else {
            first = last;
        }
        N++;
    }

    // is the deque empty?
    public boolean isEmpty() { return N == 0; }

    // return the number of items on the deque
    public int size() { return N; }

    // remove and return the item from the front
    public Item removeFirst() {
        if (N == 0) { return null; }

        Item temp = first.item;
        if (N > 1) {
            first = first.next;
            first.prev = null;
            N--;
        } else if (N == 1) {
            first = null;
            last = null;
            N = 0;
        }
        return temp;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (N == 0) { return null; }

        Item temp = last.item;
        if (N > 1) {
            last = last.prev;
            last.next = null;
            N--;
        } else if (N == 1) {
            first = null;
            last = null;
            N = 0;
        }
        return temp;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { return current != null; }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {
        Deque<Integer> que = new Deque<Integer>();
        que.addFirst(15);
        que.addFirst(5);
        que.addLast(17);

        int a = que.removeLast();
        int b = que.removeLast();
        int c = que.removeLast();

        String d = null;
        que.removeLast();
        que.removeFirst();
        System.out.printf("%d %d %d %n", a, b, c);

        que.addFirst(11);
        que.addFirst(22);
        que.addLast(33);

        Iterator l = que.iterator();
        System.out.printf("%d %d %d", l.next(), l.next(), l.next());

    }
}
