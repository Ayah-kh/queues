public class Deque<Item> implements Iterable<Item> {
   private Node first,last;

    // construct an empty deque
    public Deque() {

    }

    // unit testing (required)
    public static void main(String[] args) {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the deque
    public int size() {
        return 0;
    }

    // add the item to the front
    public void addFirst(Item item) {
        Node oldFirst=first;
        first=new Node();
        first.item=item;
        first.next=oldFirst;
        if (isEmpty())
            first=last;
    }

    // add the item to the back
    public void addLast(Item item) {
        Node oldLast = last;
        last=new Node();
        last.item=item;
        last.next=null;
        if (isEmpty())
            first=last;
        else
            oldLast.next=last;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Item item= first.item;
        first=first.next;
        if (isEmpty())
            last=null;
        return item;

    }

    // remove and return the item from the back
    public Item removeLast() {
        Item item= last.item;

        last=null;
        if (isEmpty())
            first=null;
        return item;
    }

    // return an iterator over items in order from front to back
    @Override
    public java.util.Iterator<Item> iterator() {
        return new dequeIterator<>();

    }

    private class dequeIterator<Item> implements java.util.Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

}


