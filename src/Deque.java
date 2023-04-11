public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    // construct an empty deque
    public Deque() {

    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque deque=new Deque();
        System.out.println("deque.isEmpty() before = " + deque.isEmpty());
        deque.addFirst("Hello");
        deque.addLast("Bey");
        System.out.println("deque.size = " + deque.size());
        System.out.println(deque.isEmpty());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println("deque.size = " + deque.size());
        System.out.println(deque.isEmpty());
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size==0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (isEmpty()){
            first=new Node();
            size++;
            first.item=item;
            first.next=null;
            first.prev=null;
            last=first;
        }else {
            Node oldFirst = first;
            first = new Node();
            size++;
            first.item = item;
            first.next = oldFirst;
            oldFirst.prev = first;
            first.prev = null;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (isEmpty()){
            last=new Node();
            size++;
            last.item=item;
            last.next=null;
            last.prev=null;
            first=last;
        }else {
            Node oldLast = last;
            last = new Node();
            size++;
            last.item = item;
            last.next = null;
            last.prev = oldLast;
            oldLast.next = last;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if (first==null)
            first=last;
        else
        first.prev=null;
        size--;
        return item;

    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        Item item = last.item;
        last=last.prev;
        if (last==null)
            last=first;
        else
        last.next=null;
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    @Override
    public java.util.Iterator<Item> iterator() {
        return new dequeIterator<>();

    }

    private class dequeIterator<Item> implements java.util.Iterator {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();

            current = current.next;
            return (Item) current.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

}


