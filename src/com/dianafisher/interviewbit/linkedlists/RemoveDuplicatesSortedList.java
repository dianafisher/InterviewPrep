package com.dianafisher.interviewbit.linkedlists;

/*
* Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

* */

/*
* Naive approach:
* Create a new list, using a hashtable to test if a value has already been added.
* */

/*
* Efficient approach:
* Traverse the list and remove successive nodes with the same value as the current node.
* */

import com.dianafisher.interviewbit.data_structures.ListNode;

public class RemoveDuplicatesSortedList {

    public ListNode deleteDuplicates(ListNode a) {
        ListNode current = a;
        while (current != null) {
            ListNode next = current.next;
            // continue deleting nodes while next == current
            while (next != null && next.val == current.val) {
                next = next.next;
            }
            // move current to next node in list
            current.next = next;
            current = next;
        }

        return a;
    }

    public ListNode deleteDuplicates_Editorial(ListNode a) {
        ListNode current = a;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return a;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2};
        ListNode a = ListUtils.listFromArray(arr);
        ListUtils.printList(a);

        RemoveDuplicatesSortedList solution = new RemoveDuplicatesSortedList();
        solution.deleteDuplicates(a);

        ListUtils.printList(a);

        int[] arrb = {1, 1, 2, 3, 3};
        ListNode b = ListUtils.listFromArray(arrb);
        ListUtils.printList(b);
        solution.deleteDuplicates(b);

        ListUtils.printList(b);

        int[] arrc = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6};

//        int[] arrc = new int[400];
//        int val = 1;
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 20; j++) {
//                int idx = (20 *i ) +j;
//                arrc[idx] = val;
//            }
//            val++;
//        }



        ListNode c = ListUtils.listFromArray(arrc);
        ListUtils.printList(c);
        solution.deleteDuplicates(c);

        ListUtils.printList(c);
    }
}


/*
*  0 - 19 = 1
* 20 - 39 = 2
* 40 - 59 = 3
* .
* .
* .
* 380 - 399 = 20
*
* */