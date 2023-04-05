public class Deque<Item> implements Iterable<Item> {
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
    }

    // add the item to the back
    public void addLast(Item item) {
    }

    // remove and return the item from the front
    public Item removeFirst() {
        return null;

    }

    // remove and return the item from the back
    public Item removeLast() {
        return null;
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
        Node nest;
    }

}


