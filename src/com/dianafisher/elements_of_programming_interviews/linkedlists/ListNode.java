package com.dianafisher.elements_of_programming_interviews.linkedlists;

public class ListNode<T> {
    T data;
    ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public ListNode() {
        this.data = null;
        this.next = null;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode<T> current = this;
        while (current != null) {
            builder.append(current.data);
            if (current.next != null) {
                builder.append(" -> ");
            }
            current = current.next;
        }
        return builder.toString();
    }

    public void listFromArray(T[] arr) {
        this.data = arr[0];
        ListNode current = this;
        for (int i = 1; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            current.next = next;
            current = next;
        }
    }
}
