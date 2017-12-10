package com.dianafisher.interviewbit.hashing;

/*
* A linked list is given such that each node contains an additional random
* pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1

You should return a deep copy of the list. The returned answer should not contain the same
node as the original list, but a copy of them. The pointers in the returned list should not
link to any node in the original input list.

There is 1 line in the input.

Line 1: The first number N is the number of nodes in the list.
Then N numbers follow each corresponding to label of the nodes in order.
Then N more numbers follow corresponding to the index of the random node.
If index > N, index %= (N+1); if index == N, then random pointer points to NULL.

*
* */

import java.util.HashMap;

public class CopyList {

    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode c = head;

        RandomListNode current = head;
        RandomListNode resultHead = new RandomListNode(0);
        RandomListNode rp = resultHead;

        HashMap<Integer, RandomListNode> nodeMap = new HashMap<>();

        while (current != null) {
            rp.next = new RandomListNode(current.label);
            nodeMap.put(current.label, rp.next);
            rp = rp.next;
            current = current.next;
        }

        // print the output list..
        printList(resultHead);

        System.out.println(nodeMap);

        // Now assign the random pointers.
        current = head;
        rp = resultHead.next;
        while (current != null && rp != null) {
            if (current.random != null) {
                int random = current.random.label;
                System.out.println(current.label + " has random: " + random);
                RandomListNode node = nodeMap.get(random);
                rp.random = node;
            } else {
                System.out.println(current.label + " has random: NULL");
            }
            current = current.next;
            rp = rp.next;
        }


        // print the output list..
        printList(resultHead);

        return resultHead.next;
    }


    private void printList(RandomListNode head) {
        RandomListNode current = head;
        StringBuilder builder = new StringBuilder();
        while (current != null) {
            builder.append(current.label);
            if (current.random != null) {
                builder.append(" (" + current.random.label + " )");
            } else {
                builder.append(" ( NULL )");
            }
            if (current.next != null) {
                builder.append(" -> ");
            }
            current = current.next;
        }
        System.out.println(builder.toString());
    }

    private RandomListNode nodeAtIndex(RandomListNode head, int index) {
        RandomListNode current = head;
        int i = 0;
        while (current != null && i <= index) {
            if (i == index) {
                return current;
            }
            current = current.next;
            i++;
        }
        return null;
    }

    public static void main(String[] args) {
        CopyList copy = new CopyList();
        /*
        * 14 83 188 253 281 254 56 70 3 276 233 280 224 16 173 183 193 44 184 33 213 134 95 213 48 300 62 237 63
        * should return
        * 83 281 188 173 253 0 281 254 254 281 56 281 70 0 3 56 276 281 233 281 280 83 224 253 16 16 173 281
        * */

        int[] values = new int[] { 83, 188, 253, 281, 254,  56,  70,  3, 276, 233, 280, 224,  16, 173};
        int[] randoms = new int[]{183, 193,  44, 184,  33, 213, 134, 95, 213,  48, 300,  62, 237, 63};

        RandomListNode head = new RandomListNode(values[0]);
        int N = values.length;
        RandomListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new RandomListNode(values[i]);
            current = current.next;
        }

        current = head;
        int i = 0;
        while (current != null) {
            int index = randoms[i];
            if (randoms[i] == N) {
                // set random to null
            } else {
                // set the index directly
                if (index > N) {
                    index %= (N+1);
                }
                System.out.println("index = " + index);
                RandomListNode node = copy.nodeAtIndex(head, index);
                current.random = node;
                if (node != null) {
                    System.out.println("node.label = " + node.label);
                }

            }

            i++;
            current = current.next;
        }

        copy.copyRandomList(head);
    }
}
