package com.dianafisher.interviewbit.linkedlists;

/*
* Reverse a linked list. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL,

return 5->4->3->2->1->NULL.
*
* */

import com.dianafisher.interviewbit.data_structures.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode a) {

        ListNode current = a;
        ListNode prev = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    private void printList(ListNode a) {
        StringBuilder builder = new StringBuilder();
        ListNode current = a;
        while (current != null) {
            builder.append(current.val);
            if (current.next != null) {
                builder.append(" -> ");
            }
            current = current.next;
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        solution.printList(list);

        ListNode result = solution.reverseList(list);
        solution.printList(result);
    }
}
