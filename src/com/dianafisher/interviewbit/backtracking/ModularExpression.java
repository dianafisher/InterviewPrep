package com.dianafisher.interviewbit.backtracking;

/**
 * Created by dianafisher on 1/15/18.
 *
 * Implement pow(A, B) % C.

 In other words, given A, B and C,
 find (A^B)%C.

 Input : A = 2, B = 3, C = 3
 Return : 2
 2^3 % 3 = 8 % 3 = 2

 (a * b) % M = ((a % M) * (b % M)) % M

x^n % M = (x * x^(n-1)) % M = ((x % M) * (x^(n-1) % M) % M
        = (x(n/2) * x(n/2)) % M
 */

public class ModularExpression {

    public int mod(int A, int B, int C) {
        if (A == 0) return 0;

        long result = calculateMod(A, B, C);
        if (result < 0) {
            return (int)result + C;
        }
        return (int)result;
    }

    private long calculateMod(int A, int B, int C) {
        if (B == 0) return 1;

        if (B % 2 == 0) {
            long y = calculateMod(A, B/2, C);
            return ((y * y) % C);
        } else {
            long y = (A % C) * calculateMod(A, B-1, C);
            return (y % C);
        }
    }


    public static void main(String[] args) {
        ModularExpression solution = new ModularExpression();

        System.out.println(solution.mod(2, 3, 3));  //  expect 2
        System.out.println(solution.mod(5, 2, 7));  //  expect 4
        System.out.println(solution.mod(5, 3, 7));  //  expect 6
        System.out.println(solution.mod(-1, 1, 20));  //  expect 19
    }

}
