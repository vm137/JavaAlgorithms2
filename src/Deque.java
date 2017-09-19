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
        first.next = oldFirst;
    }

    // add the item to the end
    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        N++;
    }

    // is the deque empty?
    public boolean isEmpty() { return first == null; }

    // return the number of items on the deque
    public int size() { return N; }

    // remove and return the item from the front
    public Item removeFirst() {
        return (new Node()).item;
    }

    // remove and return the item from the end
    public Item removeLast(){
        if (last != null)

            return null;
        else
            return null;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return null;
    }

    // unit testing (optional)
    public static void main(String[] args) {
        Deque<Integer> que = new Deque<Integer>();
        que.addLast(17);
        que.addFirst(15);

        //int a = que.removeFirst();

        int  x = 25;
        Integer  y = new Integer(33);
    }
}
