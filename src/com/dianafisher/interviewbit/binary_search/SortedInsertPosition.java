package com.dianafisher.interviewbit.binary_search;

/*
* Given a sorted array and a target value, return the index if the target is found.
* If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0


min = 1
max = 6

k = 5 ->

* */

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {

    public int searchInsert(ArrayList<Integer> a, int b) {
        if (a == null) return 0;

        int N = a.size();
        int min = 0;// = a.get(0);
        int max = N-1;//a.get(N-1);

        if (b < a.get(0)) return 0;
        if (b > a.get(N-1)) return N;

        while (min < max) {
            int mid = min + (max-min)/2;
            if (b <= a.get(mid)) {
                if (mid > 0) {
                    if (b > a.get(mid-1)) {
                        return mid;
                    }
                }
                // b goes before mid
                max = mid-1;
            } else {
                // b goes after mid
                if (mid < N-1) {
                    if (b < a.get(mid+1)) {
                        return mid+1;
                    }
                }
                min = mid + 1;
            }

        }

        return min;
    }

    public static void main(String[] args) {
        SortedInsertPosition sip = new SortedInsertPosition();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        System.out.println(sip.searchInsert(A, 5));  // 2
        System.out.println(sip.searchInsert(A, 2));  // 1
        System.out.println(sip.searchInsert(A, 7));  // 4
        System.out.println(sip.searchInsert(A, 0));  // 0


        A = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 7, 9, 10, 14, 17));
        System.out.println(sip.searchInsert(A, 5));  // 2
        System.out.println(sip.searchInsert(A, 2));  // 1
        System.out.println(sip.searchInsert(A, 7));  // 4
        System.out.println(sip.searchInsert(A, 0));  // 0
        System.out.println(sip.searchInsert(A, 8));  // 5
        System.out.println(sip.searchInsert(A, 9));  // 5
        System.out.println(sip.searchInsert(A, 16));  // 8
    }

}
