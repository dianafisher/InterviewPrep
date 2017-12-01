package com.dianafisher.interviewprep.week1.challenges;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 11/29/17.
 *
 * A prime number (or a prime) is an integer greater than 1 that has
 * no positive divisors other than 1 and itself.
 *
 * Write a program which takes as input an int value n and returns an array of int containing all unique primes <= n.
 *
 * Example: if the value of n is 8, the function should return: {2,3,5,7}
 *
 */
public class EnumerateAllPrimes {

    public static ArrayList<Integer> sieve(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        // Create an array of lent a+1 to hold boolean values for numbers 0 through a
        boolean prime[]  = new boolean[a+1];
        // initialize the list with true values
        Arrays.fill(prime, true);

        // 0 and 1 are not prime..
        prime[0] = false;
        prime[1] = false;

        // Loop from 2 to a (inclusive and determine what numbers are prime.
        for (int i = 2; i <= a; i++) {
            if (!prime[i]) continue;

            // Loop j from i^2 to a
            // i = 3 ->   loop from 9 to a, incrementing by 3 each time
            // so, 9, 12, 15, 18, ....
            for (long j = (long) i * i; j <= (long)a; j+= i) {
                prime[(int)j] = false;
            }
        }

        for (int i = 0; i < prime.length; i++) {
//            System.out.println(i + " = " + prime[i]);
            if (prime[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(sieve(101));
    }
}
