package com.dianafisher.interviewprep.week2.challenges;

/**
 * Created by dianafisher on 12/5/17.
 */
public interface LinkedListNode<E> {

    /* getter/setter for this node's value */
    E getValue();
    void setValue(E value);

    LinkedListNode<E> getNext();
    void setNext(LinkedListNode<E> next);

    /* initialize this node and all of its subsequent nodes from an array of values,
       starting with the head value at index 0.

        @param listValues - the ordered values for the whole list
     */
    void setValuesFromArray(E[] listValues);

}
