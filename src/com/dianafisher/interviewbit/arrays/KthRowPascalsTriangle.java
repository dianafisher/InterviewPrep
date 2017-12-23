package com.dianafisher.interviewbit.arrays;

/*
* Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1].

* */

import java.util.ArrayList;

public class KthRowPascalsTriangle {

    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<>();

        // To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

        // R = 0 -> [1] => A[0] = 1
        // R = 1 -> [1, 1]  => A[0] = 1, A[1] = 1
        // R = 2 -> [1, 2, 1] => A[0] = 1, A[1] = A[

        if (A == 0) {
            result.add(1);
            return result;
        }
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(1);

        for (int r = 1; r < A; r++) {
            row = calculateRow(row, A);
//            System.out.println("row = " + row);
        }


       return row;
    }

    /*
    * k = 0 -> 1
    * k = 1 -> 1, 1
    * k = 2 -> 1, 2, 1
    * k = 3 -> 1, 3, 3, 1
    * k = 4 -> 1, 4, 6, 4, 1
    * */
    private ArrayList<Integer> calculateRow(ArrayList<Integer> previous, int k) {
        ArrayList<Integer> list = new ArrayList();
        if (k == 0) {
            list.add(1);
            return list;
        } else if (k == 1) {
            list.add(1);
            list.add(1);
            return list;
        } else {
            int n = k-1;
            list.add(1);
            for (int c = 1; c < previous.size(); c++) {
                int v1 = previous.get(c);
                int v2 = previous.get(c-1);
                int sum = v1 + v2;
                list.add(sum);
            }
            list.add(1);
            return list;
        }
    }


    public static void main(String[] args) {
        KthRowPascalsTriangle solution = new KthRowPascalsTriangle();
        ArrayList<Integer> s = solution.getRow(3);  // [1, 3, 3, 1]
        System.out.println("s = " + s);

        s = solution.getRow(6);  // [1, 3, 3, 1]
        System.out.println("s = " + s);
    }

    private ArrayList<Integer> editorialSolution() {
        public ArrayList<Integer> getRow(int a) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(1);
            for(int i=1; i<=a; i++){
                int num = (a+1-i)*res.get(i-1)/i;
                res.add(num);
            }
            return res;
        }
    }
}
