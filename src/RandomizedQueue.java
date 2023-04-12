import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        return null;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        return null;
    }

    // return an independent iterator over items in random order
    public java.util.Iterator<Item> iterator() {
        return new QueueIterator<Item>();
    }

    private class QueueIterator<Item> implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            if (isEmpty())
                throw new java.util.NoSuchElementException();
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
