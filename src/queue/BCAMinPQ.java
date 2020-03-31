package queue;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 *    I worked with Bra
 **/
public class BCAMinPQ<E extends Comparable<E>> implements BCAQueue<E> {

  /*Stores items in heap starting at index 1*/
  private ArrayList<E> heap = new ArrayList<>();
  /*Number of items in the heap.*/

  public BCAMinPQ() {
    /* dummy element in index 0, making actual elements start at index 1 */
    heap.add(null);
  }

  /**
   * Return index of the left child of element at index i.
   */
  private int leftChildOf(int i){
    return i*2;
  }

  /**
   * Return index of the right child of element at index i.
   */
  private int rightChildOf(int i){
    return i*2+1;
  }

  /**
   * Return index of the parent of element at index i.
   */
  private int parentOf(int i){
    return i/2;
  }

  /**
   * Swap the elements at indexes i1 and i2.
   */
  private void swap(int i1, int i2){
    E temp = heap.get(i1);
    heap.set(i1, heap.get(i2));
    heap.set(i2, temp);
  }

  /**
   * Push up the element at index i (swapping with bigger parent)
   * until it is at the appropriate level. (parent is smaller)
   * This will fix the heap property if the element of index i
   * is the only element out of place.
   */
  private void pushUp(int i) {
    while ( i>1) {
      if (heap.get(i/2).compareTo(heap.get(i)) < 0)  {/**/
        break;
      }
      else{
        swap(i, i / 2);
        i=i/2;
      }
    }
  }

  /** Adds a new element to the the queue. */
  public void enqueue(E o){
    /* TODO Add new element to heap, maintaining both shape and heap properties*/
    heap.add(o);
    pushUp(heap.indexOf(o));
  }

  /* Try BCAMinPQTest now! You should pass 0.1 to 0.6*/


  /**
   * Returns the next item from the queue without popping it.
   * If no item, returns null
   */
  public E peek(){
    return heap.get(1);
  }

  /* Try BCAMinPQTest now! You should pass 1a*/

  /**
   * Push down the element at index i (swapping with its smallest child)
   * until it is at the appropriate level. (children are both bigger)
   * This will fix the heap property if the element of index i
   * is the only element out of place.
   */
  private void pushDownbad(int i) {
    int child = i;
    while((rightChildOf(i)<heap.size()+1 && leftChildOf(i)<heap.size()+1)&& heap.get(i*2)!= null || heap.get(i*2+1)!=null) {
      /* TODO pick the smaller child (there might only be one!) */
      if(heap.get(i*2)!=null && heap.get(i*2+1) == null)
        child = i*2;
      else if(heap.get(i*2)==null && heap.get(i*2+1) != null)
        child = i*2+1;
      else if (heap.get(i*2).compareTo(heap.get(i*2+1) )<0)
        child = i*2;
      else
        child = i*2+1;
      if (heap.get(i).compareTo(get(child)) < 0 /* TODO stop if i is smaller than its children!*/)
        break;

      swap(i, child);/* TODO Push element at i down!*/
    }
  }

  private void pushDown(int i){
    if(size()==2&&get(i).compareTo(get(leftChildOf(i)))<0)
      return;
    else if (size()==2){
      swap(i, leftChildOf(i));
      return;
    }

    if(leftChildOf(i) >=size()){
      return;
    }
    if(get(i).compareTo(get(leftChildOf(i))) < 0 && get(i).compareTo(get(rightChildOf(i))) < 0){
      return;
    }
    else if(leftChildOf(i)==size()) {
      if(get(i).compareTo(get(leftChildOf(i)))<0)
        return;
      else {
        swap(leftChildOf(i), i);
        pushDown(leftChildOf(i));}
    }
    else if (get(leftChildOf(i)).compareTo(get(rightChildOf(i)))<0) {
      swap(leftChildOf(i), i);
      pushDown(leftChildOf(i));
    }
    else {
      swap(rightChildOf(i), i);
      pushDown(rightChildOf(i));
    }
  }

  /**
   * Removes the smallest item from the queue and returns it.
   *
   * @exception NoSuchElementException
   *                if the queue is empty.
   */
  public E dequeue(){
    if(isEmpty()){
      throw new NoSuchElementException();
    }
    if(size()==1){
      return heap.remove(1);
    }
    swap(1, size());
    E temp = heap.remove(size());

    pushDown(1);
    return temp;
  }

  /* TODO Remove minimum element in heap, maintaining both shape and heap properties*/
  /* HINT: Swap minimum element and last element FIRST! */

  /* Try BCAMinPQTest now! You should pass the remaining tests 1b through 8, and HeapSort*/

  /**
   * Returns whether the queue is empty or not.
   */
  public boolean isEmpty(){
    return size() == 0;
  }

  /**
   * Returns the number of items currently in the queue.
   */
  public int size() {
    return heap.size()-1;  // The arraylist has an extra element at position 0, hence the subtraction of 1.
  }

  /**
   * Return item at index i
   */
  public E get(int i) {
    return heap.get(i);
  }
}
