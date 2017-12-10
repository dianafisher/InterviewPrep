package com.dianafisher.interviewbit.linkedlists;
/*
* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input :

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3.
* */

public class ListCycle {

    public ListNode detectCycle(ListNode a) {

        ListNode fast = a;
        ListNode slow = a;
        boolean hasCycle = false;

        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow != null & fast != null) {
                if (slow.val == fast.val) {
                    // found cycle
                    //                System.out.println("found cycle at " + slow.val);
                    hasCycle = true;
                    break;
                }
            }
        }

        if (hasCycle) {
            fast = a;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }


        return null;
    }

    public static void main(String[] args) {
        ListCycle solution = new ListCycle();

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        // create cycle
        list.next.next.next.next = list.next;

        ListNode c = solution.detectCycle(list);
        if (c != null) {
            System.out.println("Cycle at " + c.val);
        }


    }
}
