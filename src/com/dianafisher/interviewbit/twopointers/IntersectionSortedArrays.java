package com.dianafisher.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dianafisher on 11/26/17.
 *
 * Find the intersection of two sorted arrays.
 OR in other words,
 Given 2 sorted arrays, find all the elements which occur in both the arrays.

 Input :
 A : [1 2 3 3 4 5 6]
 B : [3 3 5]

 Output : [3 3 5]

 Input :
 A : [1 2 3 3 4 5 6]
 B : [3 5]

 Output : [3 5]

 */
public class IntersectionSortedArrays {

    public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        // which list is shorter?
        List<Integer> shortList = null;
        List<Integer> longList = null;
        if (a.size() < b.size()) {
            shortList = a;
            longList = b;
        } else {
            shortList = b;
            longList = a;
        }

        System.out.println("shortList = " + shortList);
        System.out.println("longList = " + longList);
        int i = 0;
        int j = 0;
        while (i < shortList.size()) {
            int n = shortList.get(i);
            if (j >= longList.size()) {
                break;
            }
            int m = longList.get(j);

            if (n == m) {
                result.add(n);
                // increase both i and j
                i++;
                j++;
            } else if (n < m) {
                // increase i
                i++;
            } else {
                // increase j
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);

        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(3);
//        b.add(3);
        b.add(5);

        System.out.println(intersect(a, b));

        a = new ArrayList<Integer>();
        a.add(12);
        a.add(30);
        a.add(41);
        a.add(51);
        a.add(56);
        a.add(58);
        a.add(63);
        a.add(67);
        a.add(82);
        a.add(90);
        a.add(93);

        b = new ArrayList<Integer>();
        b.add(7);
        b.add(9);
        b.add(17);
        b.add(17);
        b.add(19);
        b.add(21);
        b.add(26);
        b.add(34);
        b.add(65);
        b.add(65);
        b.add(67);
        b.add(68);
        b.add(71);
        b.add(75);
        b.add(92);


        System.out.println(intersect(a, b));
    }
}
