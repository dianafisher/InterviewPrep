package com.dianafisher.elements_of_programming_interviews.linkedlists;

/*
* Write a program which takes a singly linked list L and two integers s and f as arguments, and
* reverses the order of the nodes from the sth node to the fth node, inclusive.
* The numbering begins at 1, i.e., the head node is the first node.
*
*
* Identify the start of the sublist by iterating until we reach the sth node and its predecessor.
* Once we reach the sth node, we start the reversing process and keep counting.  When we reach the fth
* node, we stop the reversion process and link the reverted section with the unreverted section.
* */


public class ReverseSingleSublist {

    public ListNode reverseSublist(ListNode<Integer> L, int start, int finish) {

        if (start == finish) return L;

        int count = 1;

        ListNode dummyHead = new ListNode(0);  // dummy head
        dummyHead.next = L;
        ListNode current = dummyHead;

        while (count++ < start) {
            current = current.next;
        }

        // Have found start, so can now begin reversing
        ListNode<Integer> p = current.next;
        while (start++ < finish) {
            ListNode<Integer> temp = p.next;
            p.next = temp.next;
            temp.next = current.next;
            current.next = temp;
        }

//        System.out.println("count = " + count);
        return dummyHead.next;

    }

    public static void main(String[] args) {
        ReverseSingleSublist solution = new ReverseSingleSublist();
        ListNode<Integer> a = new ListNode();
        Integer[] aVals = new Integer[] {11, 3, 5, 7, 2};
        a.listFromArray(aVals);
        System.out.println("a = " + a);

        ListNode b = solution.reverseSublist(a, 2, 4);
        System.out.println("b = " + b);   // expect 11 -> 7 -> 5 -> 3 -> 2

        ListNode<Integer> c = new ListNode<>();
        Integer[] values = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        c.listFromArray(values);
        System.out.println("c = " + c);

        ListNode d = solution.reverseSublist(c, 3, 6);  // expect 1 -> 2 -> 6 -> 5 -> 4 -> 3 -> 7 -> 8 -> 9
        System.out.println("d = " + d);
    }
}
