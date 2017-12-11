package com.dianafisher.interviewprep.week2.test;

import com.dianafisher.interviewbit.linkedlists.ListNode;
import com.dianafisher.interviewbit.linkedlists.ListUtils;

public class DeleteNodesGreaterThanX {

    static ListNode removeNodes(ListNode list, int x) {
        if (list == null) return null;
        ListNode dummmyHead = new ListNode(0);
        dummmyHead.next = list;

        ListNode current = dummmyHead;

        while (current.next != null) {
            if (current.next.val > x) {
                // delete this node.
                ListNode next = current.next;
                current.next = next.next;
            } else {
                current = current.next;
            }
        }

        if (list.val > x) return null;

        return list;
    }

    public static void main(String[] args) {

        int[] arra = {5, 1, 2, 3, 4, 5};
        ListNode a = ListUtils.listFromArray(arra);
        ListUtils.printList(a);
        ListNode d = removeNodes(a, 3);
        ListUtils.printList(d);

        int[] arrc = {5, 5, 5, 5, 5};
        ListNode c = ListUtils.listFromArray(arrc);
        ListUtils.printList(c);

        d = removeNodes(c, 3);
        ListUtils.printList(d);

    }
}
