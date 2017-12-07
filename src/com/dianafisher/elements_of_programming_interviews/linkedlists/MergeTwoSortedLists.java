package com.dianafisher.elements_of_programming_interviews.linkedlists;

/*
* Problem 8.1
* Merge Two Sorted Lists
*
* Consider two singly linked lists in which each node holds a number.  Assume the lists are sorted,
* i.e., numbers in the lists appear in ascending order within each list.  The merge of the two lists is a \
* list consisting of the nodes of the two lists in which numbers appear in ascending order.
* 2 -> 5 -> 7
* 3 -> 11
*
*
* */

public class MergeTwoSortedLists {

    public ListNode mergeLists(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> pa = a;  // pointer for list a
        ListNode<Integer> pb = b;  // pointer for list b
        ListNode<Integer> result = new ListNode(0);  // dummy head node
        ListNode<Integer> current = result;
        while (pa != null && pb != null) {
            if (pa.data <= pb.data) {
                current.next = pa;
                pa = pa.next;
            } else {
                current.next = pb;
                pb = pb.next;
            }
            current = current.next;
        }
        // append the remaining nodes of whichever list is not null
        current.next = pa != null ? pa : pb;
        return result;
    }


    public static void main(String[] args) {
        ListNode<Integer> a = new ListNode();
        Integer[] aVals = new Integer[] {2, 5, 7};
        a.listFromArray(aVals);
        System.out.println("a = " + a);

        ListNode<Integer> b = new ListNode();
        Integer[] bVals = new Integer[] {3, 11};
        b.listFromArray(bVals);
        System.out.println("b = " + b);

        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode<Integer> merged = solution.mergeLists(a, b);
        System.out.println("merged = " + merged);

    }
}
