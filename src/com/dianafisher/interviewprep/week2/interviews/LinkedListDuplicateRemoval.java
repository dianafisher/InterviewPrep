package com.dianafisher.interviewprep.week2.interviews;

/*
* Write a program which takes as its input an unsorted linked list of integers and
* deletes any duplicate values from the list without using a temporary buffer collection
* or any additional collection classed, such as a HashSet. Use the LinkedListNode implementation
* from this week's challenge.

Example: Given a linked list 12->11->12->21->41->43->21, the program should output: 12->11->21->41->43

Once you've implemented the algorithm, identify the time and space complexity of your solution using Big O notation.

Bonus 1

Implement an alternative solution, this time using a temporary storage buffer. This second solution
should represent a significant improvement over the first in terms of time complexity, though it will
come at the cost of additional space complexity. Be sure you can identify both using Big O notation.

Example:

12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
should return

12 -> 11 -> 41 -> 43

* */

import com.dianafisher.interviewprep.week2.challenges.LinkedListNode;
import com.dianafisher.interviewprep.week2.challenges.LinkedListNodeImpl;

import java.util.HashSet;

public class LinkedListDuplicateRemoval {

    /*
    * Input is unsorted linked list of integers.
    *
    * This implementation is O(n^2) since we are looping through
    * the list and comparing each node to each other node.
    * */
    public LinkedListNode removeDuplicates(LinkedListNode a) {

        if (a == null) return a;

        LinkedListNode current = a;
        LinkedListNode prev = null;

        while (current != null) {
            // hold on to the current node
            prev = current;
            // iterate through the list again to compare values
            LinkedListNode next = current.getNext();
            while (next != null) {
                // continue until next = null or next no longer equals current
                while (next != null && current.getValue().equals(next.getValue())) {
                    // delete next
                    prev.setNext(next.getNext());
                    next = next.getNext();
                } if (next == null ) {
                    break;
                }
                // move to next node in list
                prev = prev.getNext();
                next = next.getNext();
            }
            current = current.getNext();
        }
        return a;
    }

    public LinkedListNode removeDuplicatesWithSet(LinkedListNode head) {
        if (head == null) return head;

        LinkedListNode current = head;
        LinkedListNode prev = null;

        HashSet<Integer> valueSet = new HashSet<>();
        Integer val = (Integer)head.getValue();
        valueSet.add(val);

        while (current.getNext() != null) {
            prev = current;
            current = current.getNext();
            val = (Integer)current.getValue();
            if (valueSet.contains(val)) {
                // found duplicate, so delete node
                prev.setNext(current.getNext());
                current = prev;
            } else {
                valueSet.add(val);
            }


        }
        return head;
    }

    public LinkedListNode removeDupes(LinkedListNode head) {
        if (head == null) return head;

        LinkedListNode current = head;
        LinkedListNode prev;

        HashSet<Integer> set = new HashSet<>();
        // put the first value in set.
        Integer val = (Integer)head.getValue();
        set.add(val);

        while (current.getNext() != null) {
            prev = current;
            current = current.getNext();

            val = (Integer)current.getValue();
            if (set.contains(val)) {
                // delete node
                prev.setNext(current.getNext());
                current = prev;
            } else {
                set.add(val);
            }

        }
        return head;
    }

    private void printList(LinkedListNode a) {
        LinkedListNode current = a;
        StringBuilder b = new StringBuilder();
        while (current != null) {
            b.append(current.getValue());
            if (current.getNext() != null) {
                b.append(" -> ");
            }
            current = current.getNext();
        }
        System.out.println(b.toString());
    }

    public static void main(String[] args) {
        LinkedListDuplicateRemoval solution = new LinkedListDuplicateRemoval();
        LinkedListNodeImpl list = new LinkedListNodeImpl();
        Integer[] values = new Integer[] {12, 11, 12, 21, 41, 43, 21};
        list.setValuesFromArray(values);
        solution.printList(list);
        LinkedListNode result = solution.removeDuplicates(list);
        solution.printList(result);

        LinkedListNodeImpl list2 = new LinkedListNodeImpl();
        list2.setValuesFromArray(values);
        solution.printList(list2);
        result = solution.removeDupes(list2);
        solution.printList(result);
    }

}
