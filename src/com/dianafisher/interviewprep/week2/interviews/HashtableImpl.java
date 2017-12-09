package com.dianafisher.interviewprep.week2.interviews;

/*
*
* Implement a simple hashtable without using any special collections classes or helpers
* (you can use native Java arrays). Your implementation should minimally meet the following requirements:

Support generics for both key and value types
Implement the standard get, put, remove, size, clear, and isEmpty operations as defined in java.util.Map
Support an initial default capacity of 16 entries
Support dynamic allocation of additional capacity as needed

Bonus 1

Implement the entire java.util.Map interface by adding support for the remaining operations:

Implement containsKey and containsValue
Implement keySet, keySet, and values
Implement putAll
Hint: One standard approach to this problem would involve using two-dimensional arrays.
* */


import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashtableImpl<T> implements Map{

    private Entry[] entries;  // an array of linked lists
    private static final int SIZE = 16;
    private int capacity = 16;
    private int count = 0;

    public HashtableImpl() {
        this.entries = new Entry[SIZE];
    }

//    private int hashCode(T value) {
//        return value.hashCode();
//    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int hash = key.hashCode() % SIZE;
        Entry e = this.entries[hash];

        // is this bucket empty?
        if (e != null) {
            // override old value with new value
            if (e.getKey().equals(key)) {
                e.setValue(value);
            } else {
                // handle collisions by adding this new element to the end of the list
                while (e.next != null) {
                    e = e.next;
                }
                Entry e2 = new Entry(key, value);
                e.next = e2;
            }
        } else {
            // create a new bucket
            Entry entry = new Entry(key, value);
            this.entries[hash] = entry;
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Object getValue() {
            return this.value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getKey() {
            return this.key;
        }
    }
}


