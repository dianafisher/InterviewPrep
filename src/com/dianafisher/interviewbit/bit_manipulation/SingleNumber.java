package com.dianafisher.interviewbit.bit_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dianafisher on 1/15/18.
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example :

 Input : [1 2 2 3 1]
 Output : 3

 */
public class SingleNumber {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {

        // A value XOR'd by itself = 0.  So use XOR to eliminate duplicate entries.
        int p = 0;
        for (int i = 0; i < A.size(); i++) {
            p ^= A.get(i);
        }
        return p;
    }

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1));
        System.out.println(s.singleNumber(A));  // expect 3;

    }
}
