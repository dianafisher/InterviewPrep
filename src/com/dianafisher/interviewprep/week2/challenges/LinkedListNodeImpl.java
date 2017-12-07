package com.dianafisher.interviewprep.week2.challenges;

public class LinkedListNodeImpl<E> implements LinkedListNode<E> {

    private E value;
    private LinkedListNode<E> next;

    public LinkedListNodeImpl() {
        this.value = null;
        this.next = null;
    }

    public LinkedListNodeImpl(E value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public E getValue() {
        return this.value;
    }

    @Override
    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public LinkedListNode<E> getNext() {
        return this.next;
    }

    @Override
    public void setNext(LinkedListNode<E> next) {
        this.next = next;
    }

    @Override
    public void setValuesFromArray(E[] listValues) {
        this.value = listValues[0];
        LinkedListNode current = this;
        for (int i = 1; i < listValues.length; i++) {
            LinkedListNode next = new LinkedListNodeImpl(listValues[i]);
            current.setNext(next);
            current = next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = null;
        Integer[] listValues = new Integer[] {1, 2, 3};

        head = new LinkedListNodeImpl<>();
        head.setValuesFromArray(listValues);

        System.out.println(head.getValue());
        System.out.println(head.getNext());
        System.out.println(head.getNext().getValue());
        System.out.println(head.getNext().getNext().getValue());

//        assertEquals(listValues[0], head.getValue());
//        assertNotNull(head.getNext());
//        assertEquals(listValues[1], head.getNext().getValue());
//        assertNotNull(head.getNext().getNext());
//        assertEquals(listValues[2], head.getNext().getNext().getValue());
//        assertNull(head.getNext().getNext().getNext());
    }
}

