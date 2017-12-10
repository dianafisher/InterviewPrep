package com.dianafisher.interviewbit.hashing;

public class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int x) { this.label = x; }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("label: ").append(this.label);
        if (this.random != null) {
            result.append(", random: ").append(this.random.label);
        } else {
            result.append("random: NULL");
        }

        return result.toString();
    }
}
