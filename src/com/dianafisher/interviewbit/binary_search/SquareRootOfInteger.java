package com.dianafisher.interviewbit.binary_search;

/*
* Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3

DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
* */

/*
* 11 ->   low = 1, hi = 11/2 = 5
*          mid = (1+5)/2 = 3
*           3^2 = 9
* */

public class SquareRootOfInteger {

    public int sqrt(int a) {

        if (a == 0) return 0;

        long lo = 0;
        long hi = a/2 + 1;
        long mid;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
//            System.out.println("mid = " + mid);

            long product = mid * mid;
//            System.out.println("product = " + product);
            if (product == a) {
                return (int)mid;
            }
            if (product < a) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return (int)hi;
    }

    public static void main(String[] args) {

        SquareRootOfInteger sri = new SquareRootOfInteger();
        System.out.println(sri.sqrt(9));  // 3
        System.out.println(sri.sqrt(11));  // 3
        System.out.println(sri.sqrt(25));  // 5
        System.out.println(sri.sqrt(2));  // 1
        System.out.println(sri.sqrt(35989261));  // 1
        System.out.println(sri.sqrt(308634616));  // 1
    }
}
