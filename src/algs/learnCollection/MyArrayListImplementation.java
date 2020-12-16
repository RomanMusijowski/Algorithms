package algs.learnCollection;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class MyArrayListImplementation<E> extends AbstractList<E> implements List<E>{

    private static final int DEFAULT_CAPACITY = 10;

    //if init capacity is 0
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //if there is no init capacity
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENTDATA = {};

    private int size;

    //size will return the size of this array
    transient Object[] data;

    public MyArrayListImplementation() {
        this.data = DEFAULT_CAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayListImplementation(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.data = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalReceiveException("Bad init capacity");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    public class Itr<E> implements Iterator<E>{

        int current;
        int lastIndex = -1;
        int expectedModCount = modCount;

        public Itr() { }

        @Override
        public boolean hasNext() {
            return current != size;
        }

        @Override
        public E next() {
            checkModCount(expectedModCount);
            //size, data.length
            int i = current;
            if (i > size)
                throw new NoSuchElementException();
            Object[] data = MyArrayListImplementation.this.data;
            if (i> data.length)
                throw new ConcurrentModificationException();
            current = i + 1;
            return (E) data[lastIndex = i];
        }

        @Override
        public void remove() {
            if (lastIndex < 0)
                throw new IllegalStateException();
            checkModCount(expectedModCount);

            try {
                MyArrayListImplementation.this.remove(lastIndex);
                current = lastIndex;
                lastIndex = -1;
            } catch (IndexOutOfBoundsException exception) {
                throw new ConcurrentModificationException();
            }
        }

        private void checkModCount(int expectedModCount) {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("The list has been changed.");
            }
        }
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size+1);
        data[size++] = e;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(data, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        if (minCapacity - data.length > 0) {
            grow(minCapacity);
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if(newCapacity - minCapacity < 0)
            newCapacity = minCapacity;

        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hudgeCapacity(minCapacity);

//        change the size of data array (bigger copy)
        data = Arrays.copyOf(data, newCapacity);
    }

    private int hudgeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    private static int calculateCapacity(Object[] data, int minCapacity) {
        if (data == DEFAULT_CAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        checkSize(index);

        modCount++; // new modification
        E oldElement = elementData(index);
        int numMoved = size - index - 1;

        if (numMoved > 0)
            System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null; //let GC clear memory

        return oldElement;
    }

    private E elementData(int index) {
        return (E) data[index];
    }

    private void checkSize(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bounds.");
        }
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
