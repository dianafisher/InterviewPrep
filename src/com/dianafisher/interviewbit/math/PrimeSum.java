package com.dianafisher.interviewbit.math;

/*
* Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d]

If a < c OR a==c AND b < d.
*
* */

import java.util.ArrayList;

public class PrimeSum {

    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a < 2) return result;

        int n1 = 2;
        int n2 = a - n1;

        while (n1 <= n2) {
            n2 = a - n1;
            if (isPrimeNumber(n2) && isPrimeNumber(n1)) {
                result.add(n1);
                result.add(n2);
                return result;
            }
            n1++;
        }
        return result;
    }

    private boolean isPrimeNumber(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PrimeSum ps = new PrimeSum();
        ArrayList<Integer> result = ps.primesum(4);
        System.out.println("result = " + result);

        result = ps.primesum(194);
        System.out.println("result = " + result);
    }
}
