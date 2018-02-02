package com.dianafisher.interviewbit.linkedlists;

/*
* Given a linked list and a value x, partition it such that all nodes less
* than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5

prev = 1->4->3->2->5->2
current = 4->3->2->5->2

* */

import com.dianafisher.interviewbit.data_structures.ListNode;

public class PartitionList {

    public ListNode partition(ListNode a, int b) {

        // First, check if there are any nodes less than b.  If not, return original list.
        boolean found = false;
        ListNode n = a;
        while (n != null) {
            if (n.val < b) {
                found = true;
                break;
            }
            n = n.next;
        }

        if (!found) return a;

        ListNode head1 = new ListNode(0);  // store values less than b
//        ListNode head2 = new ListNode(0);  // store values equal to b
        ListNode head3 = new ListNode(0);  // store values greater than b

        ListNode p1 = head1;
//        ListNode p2 = head2;
        ListNode p3 = head3;

        ListNode current = a;

        while (current != null) {
            System.out.println("current.val = " + current.val);
            if (current.val < b) {
                p1.next = current;
                p1 = current;
            } else {
                p3.next = current;
                p3 = current;
            }

            current = current.next;
        }

        // Combine the lists
        p3.next = null;
        p1.next = head3.next;


        return head1.next;
    }

    /*
    * Solution posted in Interview Bit
    * */
    public ListNode partition_fastest(ListNode a, int b) {
        if(a == null) return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = a;

        ListNode curr = a;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;

        while(curr != null){
            if(curr.val < b){
                curr = curr.next;
                prev = prev.next;
            }
            else{
                p2.next = curr;
                prev.next = curr.next;

                curr = prev.next;
                p2 = p2.next;
            }
        }
        p2.next = null;

        prev.next = fakeHead2.next;
        return fakeHead1.next;

    }

    public static void main(String[] args) {
        PartitionList solution = new PartitionList();

        int[] arra = new int[] {1, 4, 3, 2, 5, 2};
        ListNode a = ListUtils.listFromArray(arra);
        ListUtils.printList(a);
        ListNode ar = solution.partition(a, 3);
        ListUtils.printList(ar);  // expect 1->2->2->4->3->5
    }
}

/*
*


4->1->2->2->5->3

current = 4
prev = null

// current.val >= 3
p2 = current.next // 1 -> 2 -> 2 -> 3 -> 5 -> null
p1.next = current (= 4)
p1 = temp.next (= 4)   // 0 -> 4 -> null
p1.next = null


* */