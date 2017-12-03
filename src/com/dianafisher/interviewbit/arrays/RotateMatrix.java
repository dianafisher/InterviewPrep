package com.dianafisher.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 12/2/17.
 *
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 You need to do this in place.

 Note that if you end up using an additional array, you will only receive partial score.

 Example:

 If the array is

 [
 [1, 2],
 [3, 4]
 ]
 Then the rotated array becomes:

 [
 [3, 1],
 [4, 2]
 ]
 */
public class RotateMatrix {

    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();

        /*
        * Perform the rotation in layers, starting with the outmost layer
        * */

        // move top row to right column
        /*
        * a[0][0] -> a[n-1][0]
        * a[0][1] -> a[1][1]
        * a[0][2] -> a[0][0]
        *
        *
        * */

        for (int layer = 0; layer < n/2; layer++) {

            // swap 4 cells at a time
            int j = (n-1) - layer;
            for(int i = layer; i < j; i++) {
                int top = a.get(layer).get(i);
                int left = j - i + layer;
//                System.out.println("left = " + left);
                int val = a.get(left).get(layer);
                a.get(layer).set(i, val);

                val = a.get(j).get(left);
                a.get(left).set(layer, val);

                val = a.get(i).get(j);
                a.get(j).set(left, val);

                a.get(i).set(j, top);

//                System.out.println("----");

            }
        }
//        System.out.println("----");
//
//
//        printMatrix(a);
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> a) {
        for (ArrayList<Integer> row : a) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(3, 4)));

        rotate(matrix);
        printMatrix(matrix);
        /*
        * input   [1, 2]
        *         [3, 4]
        *
        * expect [3, 1]
        *        [4, 2]
        * */


        System.out.println();
        matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

        rotate(matrix);
        printMatrix(matrix);
        /*
        * input [1, 2, 3]
        *       [4, 5, 6]
        *       [7, 8, 9]
        *
        * output [7, 4, 1]
        *        [8, 5, 2]
        *        [9, 6, 3]
        * */

        System.out.println();
        matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(9, 10, 11, 12)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(13, 14, 15, 16)));

        rotate(matrix);
        printMatrix(matrix);
        /*
        * input [1, 2, 3, 4]
        *       [5, 6, 7, 8]
        *       [9, 10, 11, 12]
        *       [13, 14, 15, 16]
        *
        * output [13,  9, 5, 1]
        *        [14, 10, 6, 2]
        *        [15, 11, 7, 3]
        *        [16, 12, 8, 4]
        * */

    }
}
