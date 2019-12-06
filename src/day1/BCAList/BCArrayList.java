package day1.BCAList;

public class BCArrayList<E> implements BCAList<E>{

    protected Object[] array = new Object[5];
    protected int listSize = 0;

    private void expand() {

        Object[] newArray = new Object[array.length*2];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public void add(E o) {
        if (listSize >= array.length) {
            expand();
        }
        array[listSize++] = o;
    }


    @Override
    public void add(int index, E o) {

        if (index > listSize) {
            throw new IndexOutOfBoundsException("Index of " + index + " is out of bounds.");
        }
        if (listSize >= array.length) {
            expand();
        }

        for (int i = listSize-1; i >= index; i --) {
            array[i+1] = array[i];
        }
        listSize++;
    }

    @Override
    public void clear() {
        listSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    @Override
    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        return (E)array[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E o) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        E ret = (E) array[index];
        array[index] = o;
        return ret;
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < listSize; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public int lastIndexOf(E o) {
        for (int i = listSize-1; i >= 0; i--) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        E ret =  (E)array[index];

        for (int i = index; i < listSize-1; i++) {
            array[i] =  array[i+1];
        }
        listSize--;
        return ret;
    }

    @Override
    public boolean remove(E o) {

        int i = indexOf(o);

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

        for (int i = 0; i < listSize; i++) {
            out+= i + ": " + array[i] + "; ";
        }
        return out;
    }
}
