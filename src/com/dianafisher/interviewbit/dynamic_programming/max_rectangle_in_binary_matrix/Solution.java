package com.dianafisher.interviewbit.dynamic_programming.max_rectangle_in_binary_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by dianafisher on 2/1/18.
 *
 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

 Bonus if you can solve it in O(n^2) or less.

 Example :

 A :
 [  1 1 1
    0 1 1
    1 0 0
 ]

 Output : 4

 As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

 */
public class Solution {

    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {

        if (A == null) return 0;

        int N = A.size();
        int M = A.get(0).size();


        int area = calculateArea(A.get(0), M);
//        System.out.println("area = " + area);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cell = A.get(i).get(j);
                if (cell == 1) {
                    int val = A.get(i-1).get(j);
                    int cur = A.get(i).get(j);
                    A.get(i).set(j, val+cur);
                }
            }
            area = Math.max(area, calculateArea(A.get(i), M));
        }


        return area;
    }

   private int calculateArea(ArrayList<Integer> row, int col) {
       Stack<Integer> stack = new Stack<>();

//       for (int i = 0; i < row.size(); i++) {
//           System.out.print(row.get(i) + " ");
//       }
//
//       System.out.println();
       int maxArea = 0;
       int area = 0;
       int top = 0;

       int i = 0;
       while (i < col) {

           if (stack.isEmpty() || row.get(stack.peek()) <= row.get(i)) {
               stack.push(i++);
           } else {
               top = row.get(stack.peek());
               stack.pop();
               area = top * i;

               if (!stack.isEmpty()) {
                   area = top * (i - stack.peek() - 1);
               }
               maxArea = Math.max(maxArea, area);
           }
       }

       while (!stack.isEmpty()) {
           top = row.get(stack.peek());
           stack.pop();
           area = top * i;

           if (!stack.isEmpty()) {
               area = top * (i - stack.peek() - 1);
           }
           maxArea = Math.max(maxArea, area);
       }
//       System.out.println("maxArea = " + maxArea);
       return maxArea;
   }


    public static void main(String[] args) {

        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        grid.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        grid.add(new ArrayList<>(Arrays.asList(1, 0, 0)));

        System.out.println(s.maximalRectangle(grid));

    }
}
