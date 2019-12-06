package day1.BCAList;

public class BCALinkedList<E> implements BCAList<E> {
    protected Node<E> head = null;
    protected Node<E> tail = null;
    protected int listSize;
    @Override
    public void add(E e) {
        add(listSize, e);
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException("Index of " + index + "is out of bounds.");
        }

        Node <E> n = new Node <E>(e);

        if (index == 0) {
            n.next = head;
            head = n;

            if (listSize == 0) {
                tail = n;
            }
        }
        else if (index == listSize) {
            tail.next = n;
            tail = n;
        }
        else {
            Node<E> p = head;
            for (int i = 1; i < index; i++) {
                p = p.next;
            }
            n.next = p.next;
            p.next = n;
        }
        listSize++;
    }

    @Override
    public void clear() {

        listSize = 0;
        head = null;
        tail = null;

    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException("Index of " + index + "is out of bounds.");
        }
        Node<E> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.data;
    }

    @Override
    public E set(int index, E e) {
        if (index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException("Index of " + index + "is out of bounds.");
        }
        Node<E> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        E ret = n.data;
        n.data = e;
        return ret;
    }

    @Override
    public int indexOf(E e) {

        Node <E> n = head;
        int i = 0;
        while (n != null) {
            if (n.data.equals(e)) {
                return i;
            }
            n = n.next;
            i++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public int lastIndexOf(E e) {
        Node <E> n = head;
        int i = listSize;
        int lastPos = -1;
        while (n != null) {
            if (n.data.equals(e)) {
                lastPos = i;
            }
            n = n.next;
            i++;
        }
        return lastPos;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException("Index of " + index + "is out of bounds.");
        }

        E retVal = null;
        if (listSize == 1) {
            retVal = head.data;
            head = null;
            tail = null;
        }
        else if (index == 0) {
            retVal = head.data;
            head = head.next;
        }
        else {
            Node<E> p = head;
            for (int i = 1; i < index; i++) {
                p = p.next;
            }
            retVal = p.next.data;
            p.next = p.next.next;
            if (p.next == null) {
                tail = p;
            }
        }
        listSize--;
        return retVal;
    }

    @Override
    public boolean remove(E e) {
        int i = indexOf(e);

        if (i != -1) {
            remove(i);
            return true;
        }
        return false;
    }


    @Override
    public int size() {
        return listSize;
    }

    public String toString() {
        String out = "";
        int i = 0;
        Node<E> n = head;

        while (n != null) {
            out += i + ": " + n.data + "; ";

            i++;
            n = n.next;
        }
        return out;


    }

}

class Node<E> {
    E data = null;
    Node <E> next = null;

    public Node (E e) {
        this.data = e;
    }
}
