package com.dianafisher.interviewbit.heaps_and_maps;

/*
* Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

* */

import com.dianafisher.interviewbit.linkedlists.ListNode;
import com.dianafisher.interviewbit.linkedlists.ListUtils;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    public ListNode mergeKLists(ArrayList<ListNode> a) {

        if (a == null) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(a.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) return 1;
                if (o1.val < o2.val) return -1;
                return 0;
            }
        });

        for (ListNode node : a) {
            ListNode current = node;
            while (current != null) {
                queue.add(current);
                current = current.next;
            }
        }

        // Turn the queue into a linked list
        ListNode head = new ListNode(0);  // dummy head.
        ListNode current = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            System.out.println(node.val);
        }
        return head.next;

    }

    public static void main(String[] args) {
        MergeKSortedLinkedLists solution = new MergeKSortedLinkedLists();

        int[] arr1 = {1, 10, 20};
        int[] arr2 = {4, 11, 13};
        int[] arr3 = {3, 8, 9};

        ListNode list1 = ListUtils.listFromArray(arr1);
        ListNode list2 = ListUtils.listFromArray(arr2);
        ListNode list3 = ListUtils.listFromArray(arr3);

        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        ListNode result = solution.mergeKLists(lists);
        ListUtils.printList(result);
    }
}
