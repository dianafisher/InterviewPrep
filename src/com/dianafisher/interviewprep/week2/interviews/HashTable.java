package com.dianafisher.interviewprep.week2.interviews;

// package whatever; // don't place package name!

import java.io.*;


public class HashTable<K,V> {
    //get, put, remove, size, clear, and isEmpty

    class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;
    }

    HashNode[] buckets = new HashNode[16];
    int size = 0;

    int THRESHOLD = 75;

    public V get(K key) {
        int hash = key.hashCode();
        int bucketIndex = hash % buckets.length;
        HashNode head = buckets[bucketIndex];

        if (head == null) {
            return null;
        }
        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    private void grow() {
        int used = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                used++;
            }
        }
        int load = used * 100 / buckets.length;

        if (load < THRESHOLD) {
            return;
        }

        //grow
        HashNode[] oldBuckets = buckets;
        buckets = new HashNode[buckets.length *2];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                HashNode head = buckets[i];
                    while (head != null) {
                        put(head.key, head.value);
                        head = head.next;
                    }
                }
            }
        }
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int bucketIndex = hash % buckets.length;
        HashNode head = buckets[bucketIndex];

        if (head == null) {
            HashNode node = new HashNode();
            node.key = key;
            node.value = value;
            buckets[bucketIndex] = node;
            size++;
            grow();
            // grow if load is greater than threshold
            return;
        }

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode node = new HashNode();
        node.key = key;
        node.value = value;
        node.next = buckets[bucketIndex];
        buckets[bucketIndex] = node;
        size++;
        grow();
    }

    public V remove(K key) {
        int hash = key.hashCode();
        int bucketIndex = hash % buckets.length;
        HashNode head = buckets[bucketIndex];

        if (head == null) {
            return;
        }

        HashNode prev = head;

        while (head != null) {
            if (head.key == key) {
                // first node in the list
                if (head == buckets[bucketIndex]) {
                    buckets[bucketIndex] = head.next;
                } else {

                    // middle
                    // end
                    prev.next = head.next;
                }
                size--;
                return head.value;
            }

            prev = head;
            head = head.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//  Implement containsKey and containsValue

    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        HashNode head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    public boolean containsValue(V value) {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                HashNode head = buckets[i]; {
                    while (head != null) {
                        if (head.value == value) {
                            return true;
                        }
                        head = head.next;
                    }
                }
            }
        }
        return false;
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<K>();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                HashNode head = buckets[i] {
                    while (head != null) {
                        keys.add(head.key);
                        head = head.next;
                    }
                }
            }
        }
        return keys;
    }

    public Set<V> values() {
        Set<K> values = new HashSet<K>();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                HashNode head = buckets[i] {
                    while (head != null) {
                        values.add(head.value);
                        head = head.next;
                    }
                }
            }
        }
        return values;
    }

    public void putAll(Map input) {
        for (K key : input.keySet) {
            put(key, input.get(key));
        }
    }

    private int getBucketIndex(K key) {
        int hash = key.hashCode();
        return hash % buckets.length;
    }
}














































//unsorted

//Example: Given a linked list 12->11->12->21->41->43->21,
// the program should output: 12->11->21->41->43


/*
current

*/

public class MyCode {
    public LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {

        if (head == null) return head;

        LinkedListNode current = head; // 12
        LinkedListNode prev = null; // 12


        while (current != null) {
            prev = current; //
            // iterate through the list and compare each node to every other node.
            LinkedListNode next = current.getNext(); // 11
            while (next != null) {
                while (next != null && current.getValue().equals(next.getValue())) {
                    // delete next
                    prev.setNext(next.getNext());
                    next = next.getNext();

                }
                if (next == null) {
                    break;
                }
                prev = prev.getNext();
                next = next.getNext();
            }


            current = current.getNext();
        }

        return head;

    }

    public LinkedListNode<Integer> removeDuplicates2(LinkedListNode<Integer> head) {

        if (head == null) return head;

        LinkedListNode current = head;  // 12
        LinkedListNode prev = null;

        HashSet<Integer> set = new HashSet<Integer>set();
        Integer val = head.getValue();
        set.add(val);  // 12

        while (current.getNext() != null) {
            prev = current;  // 11
            current = current.getNext();  // 21
            val = current.getValue(); // 21

            if (set.contains(val)) {
                // delete node
                prev.setNext(current.getNext());  // null
                current = prev;  //  21
            } else {
                set.add(val); // 12, 11, 21, 41, 43
            }
        }

        return head;
    }

    public static void main (String args[]) {
        LinkedListNodeImpl<Integer> head = new LinkedListNodeImpl<Integer>();
        Integer[] arr = new Integer[] {12, 11, 12, 21, 41, 43, 21};
        head.setValuesFromArray(arr);

        MyCode s = new MyCode();
        LinkedListNode<Integer> result = s.removeDuplicates(head);
    }
}


public interface LinkedListNode<E> {

    /* getter/setter for this node's value */
    E getValue();
    void setValue(E value);

    LinkedListNode<E> getNext();
    void setNext(LinkedListNode<E> next);

    /* initialize this node and all of its subsequent nodes from an array of values,
       starting with the head value at index 0.

        @param listValues - the ordered values for the whole list
     */
    void setValuesFromArray(E[] listValues);

}

public class LinkedListNodeImpl<E> implements LinkedListNode<E> {

    private E value;
    private LinkedListNode<E> next;

    public LinkedListNodeImpl() {
        this.value = null;
        this.next = null;
    }

    public LinkedListNodeImpl(E value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public E getValue() {
        return this.value;
    }

    @Override
    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public LinkedListNode<E> getNext() {
        return this.next;
    }

    @Override
    public void setNext(LinkedListNode<E> next) {
        this.next = next;
    }

    @Override
    public void setValuesFromArray(E[] listValues) {
        this.value = listValues[0];
        LinkedListNode current = this;
        for (int i = 1; i < listValues.length; i++) {
            LinkedListNode next = new LinkedListNodeImpl(listValues[i]);
            current.setNext(next);
            current = next;
        }
    }
}