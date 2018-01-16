package com.dianafisher.interviewbit.backtracking;

import java.util.ArrayList;

/**
 * Created by dianafisher on 1/16/18.
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code,
 print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2

 There might be multiple gray code sequences possible for a given n.
 Return any such sequence.

 */
public class GrayCode {

    public ArrayList<Integer> grayCode(int a) {
        if (a == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        ArrayList<Integer> result = grayCode(a-1);
        int next = 1 << (a-1);
        for (int i = result.size()-1; i > -1; i--) {
            result.add(next + result.get(i));
        }
        return result;
    }


    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        System.out.println(gc.grayCode(2));  // expect [0,1,3,2]
        System.out.println(gc.grayCode(3));  // expect [0,1,3,2]
    }
}
