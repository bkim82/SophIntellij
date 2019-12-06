package day1.BCAList;


public class BCArrayList2<E> implements BCAList<E>{

    protected Object[] array = new Object[5];
    protected int listSize = 0;

    @Override
    public void add(E e) {
//        if (listSize + 1 > array.length ) {
////            expand();
////        }
        array[listSize++] = e;
    }

    @Override
    public void add(int index, E e) {
        if (index >= listSize) {
            throw new IndexOutOfBoundsException("Space not available");
        }

        for (int i = listSize-1; i >= index; i--) {
            array[i+1] = array[i];
        }
        array[index] = e;
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
    public boolean contains(E e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index > listSize - 1) {
            throw new IndexOutOfBoundsException("No index");
        }
        return (E)array[index];
    }

    @Override
    public E set(int index, E e) {

        E ret = (E)array[index];
        array[index] = e;
        return ret;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < listSize; i++) {
            if (array[i].equals(e)) {
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
    public int lastIndexOf(E e) {
        for (int i = listSize; i > 0; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {

        E a = (E)array[index];

       for (int i = 0; i < array.length-1; i ++) {
           array[i] = array[i+1];
       }
       listSize--;
       return a;
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < listSize; i++) {
            if (array[i].equals(e)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return listSize;
    }
}
