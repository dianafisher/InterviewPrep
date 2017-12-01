package com.dianafisher.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 11/27/17.
 *
 * You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to
 (x+1, y),
 (x - 1, y),
 (x, y+1),
 (x, y-1),
 (x-1, y-1),
 (x+1,y+1),
 (x-1,y+1),
 (x+1,y-1)
 You are given a sequence of points and the order in which you need to cover the points.
 Give the minimum number of steps in which you can achieve it. You start from the first point.

 Example :

 Input : [(0, 0), (1, 1), (1, 2)]
 Output : 2
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).


 */
public class MinStepsInfiniteGrid {

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int minSteps = 0;
        int n = X.size();

        if (n == 0) return 0;

        int x = X.get(0);
        int y = Y.get(0);

        for (int i = 1; i < n; i++) {
            int nextX = X.get(i);
            int nextY = Y.get(i);

            int deltaX = Math.abs(x - nextX);
            int deltaY = Math.abs(y - nextY);

            if (deltaX == deltaY) {
                minSteps += deltaX;
            } else if (deltaX > deltaY) {
                // move in x direction
                minSteps += deltaX;
            } else {
                // move in y direction
                minSteps += deltaY;
            }
            x = nextX;
            y = nextY;
        }
        return minSteps;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 8, -7, -5, -13, 9, -7, 8));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8));

        System.out.println(coverPoints(A, B)); // expect 108

        A = new ArrayList<Integer>(Arrays.asList(-7, -13));
        B = new ArrayList<Integer>(Arrays.asList(1, -5));

        System.out.println(coverPoints(A, B)); // expect 6
    }
}
