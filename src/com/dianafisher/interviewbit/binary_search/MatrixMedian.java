package com.dianafisher.interviewbit.binary_search;

/*
* Given a N cross M matrix in which each row is sorted, find the overall median of the matrix.
* Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.
* */

public class MatrixMedian {

    public int findMedian(int[][] A) {

        // 1. Find min and max elements in the matrix.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int N = A.length;

        if (N == 0) return -1;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int val = A[r][c];
                min = Math.min(val, min);
                max = Math.max(val, max);
            }
        }

//        System.out.println("min = " + min);
//        System.out.println("max = " + max);

        int target = (N * N + 1) / 2;
//        System.out.println("target = " + target);

        while (min < max) {
            int mid = min + (max - min)/2;
//            System.out.println("mid = " + mid);
            int index = 0;

            // search the right half of each row.
            for (int r = 0; r < N; r++) {
                int insertAt = insertionPoint(A[r], mid);
//                System.out.println("row " + r + " insertion point for " + mid + ": " + insertAt);
                index += insertAt;
            }

            if (index < target) {
                // adjust min
                min = mid + 1;
            } else {
                max = mid;
            }

        }

        return min;
    }

    /*
    * Returns the insertion point for k in array A
    * */
    private int insertionPoint(int[] A, int k) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > k) return i;
        }
        return A.length;
    }


    public static void main(String[] args) {
        MatrixMedian mm = new MatrixMedian();

        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(mm.findMedian(matrix));
    }
}
