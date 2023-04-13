import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] array;
    private int lastIndex;

    // construct an empty randomized queue
    public RandomizedQueue() {
        @SuppressWarnings("unchecked")
        Item[] a = (Item[]) new Object[1];
        array = a;
        lastIndex = -1;
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size()==0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return lastIndex+1;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (lastIndex+1==array.length){
            resize(array.length*2);
        }
        array[++lastIndex]=item;

    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();

        int i=StdRandom.uniformInt(lastIndex+1);
        Item removed=array[i];
        array[i]=array[lastIndex];
        array[lastIndex--]=null;
        if (size()>0&&size()== array.length/4)
            resize(array.length/2);

        return removed;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        Item sample=null;
        while (sample==null)
            sample=array[StdRandom.uniformInt(lastIndex+1)];
        return null;
    }

    private void resize(int newCapacity){
        @SuppressWarnings("unchecked")
                Item[] newArray=(Item[]) new Object[newCapacity];
        int i=0;
        int j=0;
        while (i<=lastIndex){
            newArray[j++]=array[i++];
        }
        array=newArray;
        lastIndex=j-1;
    }

    // return an independent iterator over items in random order
    public java.util.Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Item[] copiedArray;
        private int copiedLastIndex;

        QueueIterator(){
            @SuppressWarnings("unchecked")
                    Item[] a =(Item[]) new Object[lastIndex+1];
            for (int i = 0; i <=lastIndex; i++) {
                a[i]=array[i];
            }
            copiedArray=a;
            copiedLastIndex=lastIndex;
        }


        @Override
        public boolean hasNext() {
            return copiedLastIndex>=0;
        }

        @Override
        public Item next() {
            if (isEmpty())
                throw new java.util.NoSuchElementException();
            int i =StdRandom.uniformInt(copiedLastIndex+1);
            Item item=copiedArray[i];
            copiedArray[i]=copiedArray[copiedLastIndex];
            copiedArray[copiedLastIndex--]=null;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
