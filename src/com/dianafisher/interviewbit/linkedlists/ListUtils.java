package com.dianafisher.interviewbit.linkedlists;

import com.dianafisher.interviewbit.data_structures.ListNode;

public class ListUtils {

    public static void printList(ListNode a) {
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

    public static ListNode listFromArray(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

}
