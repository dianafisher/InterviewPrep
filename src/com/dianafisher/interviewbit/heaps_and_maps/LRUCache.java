package com.dianafisher.interviewbit.heaps_and_maps;

/*
* Design and implement a data structure for Least Recently Used (LRU) cache.
* It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present.
When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity.
Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set
operation of the item. “Least recently used” item is the one with the oldest access time.


 NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :

Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1
* */

import java.util.HashMap;

public class LRUCache {

    private int capacity;
    private HashMap<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.val;
        }
        return -1;
    }

    private void removeNode(ListNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void setHead(ListNode node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            // replace..
            ListNode old = map.get(key);
            old.val = value;
            removeNode(old);
            setHead(old);
        } else {
            // create a new node..
            ListNode node = new ListNode(key, value);
            if (map.size() >= capacity) {
                System.out.println("tail = " + tail);
                map.remove(tail.key);
                removeNode(tail);
                setHead(node);
            } else {
                setHead(node);
            }
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.set(5, 12);

        System.out.println(cache.get(5)); // returns 12
        System.out.println(cache.get(1)); // returns 10
        System.out.println(cache.get(10)); // returns -1
        cache.set(6, 14);
        System.out.println(cache.get(5)); // returns -1
    }
}

class ListNode {
    public int key;
    public int val;
    public ListNode next;
    public ListNode prev;
    public ListNode(int key, int value) {
        this.key = key;
        val = value;
        next = null;
        prev = null;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(this.val);
//        return builder.toString();
//    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            builder.append(current.val);
            if (current.next != null) {
                builder.append(" -> ");
            }
            current = current.next;
        }
        return builder.toString();
    }
}