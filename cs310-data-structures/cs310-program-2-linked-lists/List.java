/*
 * Interface will be implemented in SinglyLinkedList.java,
 * methods given by the prompt
 *
 * Program 2: Linked List
 * Dalton Tarde
 * CS-310 Section 1
 * October 30, 2020
 */

package edu.sdsu.cs.datastructures;

public interface List<E> {
    public boolean add(E datum); // datum is appended to the END of the list
    public boolean add(List<E> other); // appends every datum, in order, in the other list to the rear of this list
    public boolean addFirst(E datum); // datum is appended to the FRONT of the list
    public void clear(); // resets the list to an empty state, and does not need to override existing list contents
    public int count(E target); // returns the number of instances equal to the target value contained in the data structure. 0 -> size() is valid
    public E get(int index); // returns element stored at specified list index (front = 0, rear = -1)
    public boolean isEmpty(); // returns true if there is nothing in the list
    public E remove(int index); // removes the item stored at the specified index of the list (front = 0, rear = -1)
    public void reverse(); // reverses the list's direction, changing the list
    public E set(int index, E value); // mutates value stored at given index, then returns the previous value stored at that position
    public int size(); // returns number of items stored in the data structure
    public void sort(); // places the list in its natural order, changing the list, using type Comparable


}
