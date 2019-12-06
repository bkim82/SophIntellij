package bca.util;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class BCAStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public BCAStack() {

    }

    public void push (E e) {
        list.add(e);
    }

    public E pop() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        return (E)list.remove(list.size()-1);
    }

    public E peek() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        return (E)list.get(list.size()-1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }
}
