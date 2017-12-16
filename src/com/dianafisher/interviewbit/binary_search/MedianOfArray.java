package com.dianafisher.interviewbit.binary_search;

/*
* There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3

 NOTE: IF the number of elements in the merged array is even,
 then the median is the average of n / 2 th and n/2 + 1th element.
 For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5

From wikipedia:

The median is the value separating the higher half of a data sample,
a population, or a probability distribution, from the lower half.

For example, in the data set {1, 3, 3, 6, 7, 8, 9}, the median is 6,
the fourth largest, and also the fourth smallest, number in the sample.

*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfArray {

    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a == null && b == null) return 0;
        if (a == null) {
            // return median of b
            return medianOfArray(b);
        } else if (b == null) {
            // return median of a
            return medianOfArray(a);
        }
//        // otherwise, calculate the median of both arrays.
//        int n = a.size();
//        int m = b.size();
//
//        int targetIndex = (n+m+1) / 2;
//        System.out.println("targetIndex = " + targetIndex);
//
//        int min = Math.min(a.get(0), b.get(0));
//        int max = Math.max(a.get(n-1), b.get(m-1));
//
//        System.out.println("min = " + min);
//        System.out.println("max = " + max);
//
//        while (min < max) {
//            int mid = min + (max - min)/2;
//            System.out.println("mid = " + mid);
//            int index = 0;
//            int ipa = insertionPoint(a, mid);
//            int ipb = insertionPoint(b, mid);
//            index = ipa + ipb;
//
//            if (index < targetIndex) {
//                min = mid + 1;
//            } else {
//                max = mid;
//            }
//
//        }
//        System.out.println("min = " + min);

        int len = a.size() + b.size();
        if(len % 2 == 1) {
            return findKthSmallest(a, 0, b, 0, len/2 + 1);
        }
        return (findKthSmallest(a, 0, b, 0, len/2) + findKthSmallest(a, 0, b, 0, len/2 + 1)) / 2.0;

    }

    int findKthSmallest(final List<Integer> a, int aStart, final List<Integer> b, int bStart, int k) {
        if(aStart >= a.size()) {
            return b.get(bStart + k - 1);
        }
        if(bStart >= b.size()) {
            return a.get(aStart + k - 1);
        }
        if(k == 1) {
            return Math.min(a.get(aStart), b.get(bStart));
        }
        int aKey = 0;
        int bKey = 0;
        if(aStart + k/2 - 1 < a.size()) {
            aKey = a.get(aStart + k/2 -1);
        }
        else
            aKey = Integer.MAX_VALUE;
        if(bStart + k/2 - 1 < b.size()) {
            bKey = b.get(bStart + k / 2 -1);
        }
        else
            bKey = Integer.MAX_VALUE;

        if(aKey < bKey) {
            return findKthSmallest(a, aStart + k / 2, b, bStart, k - k / 2);
        }
        else {
            return findKthSmallest(a, aStart, b, bStart + k / 2, k - k / 2);
        }
    }

    /*
     * Returns the insertion point for k in array A
     * */
    private int insertionPoint(List<Integer> a, int k) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > k) return i;
        }
        return a.size();
    }

    private double medianOfArray(List<Integer> a) {
        int N = a.size();
        int mid = N/2;
        if (N % 2 == 0) {
            int sum = a.get(mid) + a.get(mid+1);
            return Math.floor(sum/2.0);
        } else {
            return a.get(mid);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 4, 5));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2, 3));

        MedianOfArray solution = new MedianOfArray();
        System.out.println(solution.findMedianSortedArrays(a, b));


        a = new ArrayList<>(Arrays.asList(1, 3, 7, 9));
        b = new ArrayList<>(Arrays.asList(3, 6, 8));
        System.out.println(solution.findMedianSortedArrays(a, b));
    }
}
