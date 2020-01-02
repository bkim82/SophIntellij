package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BCAQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public BCAQueue() {

    }

    public void enqueue(E e) {
        list.add(e);
    }

    public E dequeue () {
        if (list.isEmpty()) {
            throw new NoSuchElementException();

        }
        return list.remove(0);
    }
    public E peek () {
        if (list.isEmpty()) {
            throw new NoSuchElementException();

        }
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
