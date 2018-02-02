package com.dianafisher.interviewbit.linkedlists;

/*
* Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists,
and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20
* */

import com.dianafisher.interviewbit.data_structures.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {

        ListNode pa = a;
        ListNode pb = b;
        ListNode head = new ListNode(0);  // dummy head node
        ListNode current = head;

        while (pa != null && pb != null) {
            if (pa.val <= pb.val) {
                current.next = pa;
                pa = pa.next;
            } else {
                current.next = pb;
                pb = pb.next;
            }
            current = current.next;
        }

        current.next = pa != null ? pa : pb;

        return head.next;  // ignore the dummy head
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        int[] arr1 = {5, 8, 20};
        ListNode a = ListUtils.listFromArray(arr1);
        ListUtils.printList(a);

        int[] arr2 = {4, 11, 15};
        ListNode b = ListUtils.listFromArray(arr2);
        ListUtils.printList(b);

        ListNode result = solution.mergeTwoLists(a, b);
        ListUtils.printList(result);
    }
}
