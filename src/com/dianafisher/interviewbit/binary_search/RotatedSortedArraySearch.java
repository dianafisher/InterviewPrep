package com.dianafisher.interviewbit.binary_search;

/*
* Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

NOTE : Think about the case when there are duplicates. Does your current solution work?
How does the time complexity change?*

* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

    public int search(final List<Integer> a, int b) {

        int N = a.size();
        if (N == 0) return -1;

        int lo = 0;
        int high = N-1;

        while (lo <= high) {
            int mid = lo + (high - lo)/2;
            int cur = a.get(mid);
            if (b == cur) { return mid; }

            if (a.get(lo) <= cur) {
                if (cur > b && a.get(lo) <= b) {
                    high = mid-1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (cur < b && b <= a.get(high)) {
                    lo = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArraySearch solution = new RotatedSortedArraySearch();

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2));
        System.out.println(solution.search(A, 4));  // expect 0


        A = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9, 10, 0, 1, 2));
        System.out.println(solution.search(A, 2));  // expect 9

        A = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(solution.search(A, 2));  // expect

        A = new ArrayList<>(Arrays.asList(10, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(solution.search(A, 2));  // expect

    }
}
