package com.dianafisher.interviewprep.week1.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dianafisher on 11/29/17.
 *
 * A matrix is a two-dimensional array of r rows, each with c columns,
 * such that the total number of elements in the matrix is r * c.
 *
 * The spiral order of such a matrix is the list of all its elements starting at index (0, 0)
 * and proceeding in clockwise order from the outermost values to innermost values.
 *
 * Write a program that takes an int[][] matrix as its input and returns an int[] of all the
 * input's values in spiral order.
 *
 * Given
 * [[ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]]
 *
 *  Return [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */
public class SpiralOrder {

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int direction = 0; // left to right, 1 = top to bottom, 2 = right to left, 3 = bottom to top.

        int rows = a.size();
        int cols = a.get(0).size();

        int top = 0;
        int right = cols - 1;
        int bottom = rows - 1;
        int left = 0;

        while(top <= bottom && left <= right) {
            if (direction == 0) {
                // left to right
                // keep row constant (at top) and loop through cols from left to right
                for (int col = left; col <= right; col++) {
                    int val = a.get(top).get(col);
                    result.add(val);
                }
                // move top down by one
                top++;
                // set direction to top to bottom
                direction = 1;
            } else if (direction == 1) {
                // top to bottom
                // keep col constant (at right) and loop through rows
                for (int row = top; row <= bottom; row++) {
                    int val = a.get(row).get(right);
                    result.add(val);
                }
                // move right in towards the left by one
                right--;
                // set direction to right to left
                direction = 2;
            } else if (direction == 2) {
                // right to left
                // keep row constant (at bottom) and loop through cols from right to left
                for (int col = right; col >= left; col--) {
                    int val = a.get(bottom).get(col);
                    result.add(val);
                }
                // move bottom up one
                bottom--;
                // set direction to bottom to top
                direction = 3;
            } else if (direction == 3){
                // bottom to top
                // keep col constant at left and loop through rows
                for (int row = bottom; row >= top; row--) {
                    int val = a.get(row).get(left);
                    result.add(val);
                }
                // move left in one
                left++;
                // set direction to left to right
                direction = 0;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        List<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

        System.out.println(spiralOrder(matrix));

        matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(5, 6)));

        System.out.println(spiralOrder(matrix));
    }
}
