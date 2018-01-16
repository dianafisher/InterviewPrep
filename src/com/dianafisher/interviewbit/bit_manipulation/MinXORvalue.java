package com.dianafisher.interviewbit.bit_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by dianafisher on 1/15/18.
 *
 * Given an array of N integers, find the pair of integers in the array which have minimum XOR value.
 * Report the minimum XOR value.

 Examples :
 Input
 0 2 5 7
 Output
 2 (0 XOR 2)
 Input
 0 4 7 9
 Output
 3 (4 XOR 7)

 Constraints:
 2 <= N <= 100 000
 0 <= A[i] <= 1 000 000 000

 */

public class MinXORvalue {

    public int findMinXor(ArrayList<Integer> A) {

        int min = Integer.MAX_VALUE;

//        // n squared..
//        for (int i = 0; i < A.size(); i++) {
//            for (int j = i+1; j < A.size(); j++) {
//                int a = A.get(i);
//                int b = A.get(j);
////                System.out.println(a + " XOR " + b);
//                int c = a ^ b;
//                min = Math.min(min, c);
//            }
//        }

        // n log n
        Collections.sort(A);
        int val = 0;
        // can just compare adjacent entries now that the array is sorted.
        for (int i = 0; i < A.size()-1; i++) {
            val = A.get(i) ^ A.get(i+1);
            min = Math.min(min, val);
        }

        return min;
    }

    public static void main(String[] args) {
        MinXORvalue solution = new MinXORvalue();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 2, 5, 7));
        System.out.println(solution.findMinXor(A));  // expect 2

        A = new ArrayList<>(Arrays.asList(0, 4, 7, 9));
        System.out.println(solution.findMinXor(A));  // expect 3


        A = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 100000; i++) {
            int n = rand.nextInt(1000000000);
            A.add(n);
        }
        System.out.println(solution.findMinXor(A));  // expect
    }
}
