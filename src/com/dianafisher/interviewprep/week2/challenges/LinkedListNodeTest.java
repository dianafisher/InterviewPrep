package com.dianafisher.interviewprep.week2.challenges;

import static org.junit.Assert.*;
import org.junit.Test;

class LinkedListNodeTest {
    @Test
    public void test() {
        LinkedListNode<Integer> head = null;
        Integer[] listValues = new Integer[] {1, 2, 3};

        head = new LinkedListNodeImpl<>();
        head.setValuesFromArray(listValues);

        assertEquals(listValues[0], head.getValue());
        assertNotNull(head.getNext());
        assertEquals(listValues[1], head.getNext().getValue());
        assertNotNull(head.getNext().getNext());
        assertEquals(listValues[2], head.getNext().getNext().getValue());
        assertNull(head.getNext().getNext().getNext());
    }
}