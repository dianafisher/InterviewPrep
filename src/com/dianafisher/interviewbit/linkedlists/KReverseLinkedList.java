package com.dianafisher.interviewbit.linkedlists;

/*
* Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

 NOTE : The length of the list is divisible by K
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.

* */

import java.util.ArrayList;
import java.util.List;

public class KReverseLinkedList {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode curr = head;

        int count = 0;
        while (curr != null) {
            count++;
            if (count % k != 0) {
                curr = curr.next;
            } else {
                ListNode next = curr.next;

                // Reverse the list
                curr.next = null;
                List<ListNode> result = reverseList(prev.next);

                prev.next = result.get(0);
                ListNode tail = result.get(1);
                tail.next = next;
                prev = tail;
                curr = next;
            }
        }

        return dummyNode.next;
    }

    private List<ListNode> reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode tail = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        List<ListNode> result = new ArrayList<>();
        result.add(prev);
        result.add(tail);

        return result;

    }

//    public ListNode reverseList(ListNode A, int B) {
//
//        if (A == null || A.next == null || B <= 1) {
//            return A;
//        }
//
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = A;
//
//        ListNode p1 = dummyHead;
//        ListNode current = A;
//
//        int count = 0;
//
//        while (current != null) {
//            count++;
//            if (count % B == 0) {
//                p1 = reverseRange(p1, current.next);
//                current = p1.next;
//
//            } else {
//                current = current.next;
//            }
//        }
//        return dummyHead;
//    }
//
//    // Reverse the linked list from pre to end, exclusively
//    private ListNode reverseRange(ListNode prev, ListNode end) {
//        ListNode head = prev.next;
//        ListNode curr = head.next;
//
//        while (curr != end) {
//            ListNode temp = curr.next;
//            curr.next = prev.next;
//            prev.next = curr;
//
//            curr = temp;
//        }
//
//        head.next = end;
//        return head;
//    }
//
//    private ListNode reverse(ListNode a) {
//        ListNode current = a;   // 1
//        ListNode prev = null;   // null
//
//        while(current != null) {
//            ListNode temp = current.next;  // 2
//            current.next = prev;  // null  (   1 -> null )
//            prev = current; // 1
//            current = temp; // 2
//        }
//
//        return prev;
//    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};
        ListNode a = ListUtils.listFromArray(arr);
        ListUtils.printList(a);

        KReverseLinkedList k = new KReverseLinkedList();
//        a = k.reverse(a);
//        ListUtils.printList(a);
        k.reverseKGroup(a, 2);
        ListUtils.printList(a);
    }
}
