package com.dianafisher.interviewbit.linkedlists;

import com.dianafisher.interviewbit.data_structures.ListNode;

/**
 * Created by dianafisher on 12/4/17.
 *
 * Given a singly linked list, determine if its a palindrome.
 * Return 1 or 0 denoting if its a palindrome or not, respectively.

 Notes:

 Expected solution is linear in time and constant in space.
 For example,

 List 1-->2-->1 is a palindrome.
 List 1-->2-->3 is not a palindrome.
 */
public class PalindromeList {

    public static int lPalin(ListNode A) {

        if (A == null || A.next == null) return 1;

        // Use a fast and slow pointer to find the center of the list.
        ListNode fast = A;
        ListNode slow = A;

        // Move fast twice as fast as slow.
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        fast = A;

//        System.out.println("fast:");
//        printList(fast);
//        System.out.println("slow:");
//        printList(slow);

        // reverse one of the lists and compare
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // prev now points to the reversed list

        // compare the lists
        while (prev != null) {
            if (fast.val != prev.val) return 0;
            fast = fast.next;
            prev = prev.next;
        }

        return 1;
    }



    private static void printList(ListNode list) {
        ListNode cur = list;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.val);
            if (cur.next != null) {
                builder.append(" -> ");
            }
            cur = cur.next;
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(1);

        System.out.println(lPalin(list));  // expect 1

        list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);

        System.out.println(lPalin(list));  // expect 0

        list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(1);

        System.out.println(lPalin(list));  // expect 1

        list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next = new ListNode(1);

        System.out.println(lPalin(list));  // expect 0

        list = new ListNode(1);
        System.out.println(lPalin(list));  // expect 1

        list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next = new ListNode(1);
        list.next.next.next.next.next.next = new ListNode(5);

        System.out.println(lPalin(list));  // expect 0

    }
}
