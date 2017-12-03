package com.dianafisher.interviewprep.week1.test;

/**
 * Created by dianafisher on 12/2/17.
 */
public class SumThemAll {

    static int summation(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
