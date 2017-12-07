package com.dianafisher.interviewbit.linkedlists;

/**
 * Created by dianafisher on 12/4/17.
 */
public class ListNode {

    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.val);
        return builder.toString();
    }
}
