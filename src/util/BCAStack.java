package util;

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
        return list.remove(list.size()-1);
    }

    public E peek() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        return list.get(list.size()-1);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
        list.clear();
    }
}
