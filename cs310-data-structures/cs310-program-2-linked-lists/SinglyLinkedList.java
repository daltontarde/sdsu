package edu.sdsu.cs.datastructures;

public class SinglyLinkedList<E> implements List<E> {
    Node<E> head;

    public class Node<E> {
        Node next;
        E indice;

        Node(E value) {

        }
    }

    @Override
    public boolean add(E datum) {
        if (head == null) {
            
        }
        return true;
    }

    @Override
    public boolean add(List<E> other) {
        return true;
    }

    @Override
    public boolean addFirst(E datum) {
        return true;
    }

    @Override
    public void clear() {

    }

    @Override
    public int count(E target) {
        int val = 0;
        return val;
    }

    @Override
    public E get(int index) {
        E e;
        e = (E)"Test";
        return (e);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public E remove(int index) {
        E e;
        e = (E)"Placeholder";
        return (e);
    }

    @Override
    public void reverse() {

    }

    @Override
    public E set(int index, E value) {
        E e;
        e = (E)"Placeholder";
        return (e);
    }

    @Override
    public int size() {
        int size = 0;
        return size;
    }

    @Override
    public void sort() {

    }
}
