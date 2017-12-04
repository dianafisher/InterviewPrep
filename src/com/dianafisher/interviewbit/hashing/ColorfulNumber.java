package com.dianafisher.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by dianafisher on 12/4/17.
 *
 * For Given Number N find if its COLORFUL number or not

 Return 0/1

 COLORFUL number:

 A number can be broken into different contiguous sub-subsequence parts.
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 Example:

 N = 23
 2 3 23
 2 -> 2
 3 -> 3
 23 -> 6
 this number is a COLORFUL number since product of every digit of a sub-sequence are different.

 Output : 1
 */
public class ColorfulNumber {

    public static int colorful(int a) {
        // break a into individual digits..
        ArrayList<Integer> digits = new ArrayList<Integer>();

//        System.out.println("a = " + a);
        while (a > 0) {
//            System.out.println("a = " + a);
            int rem = a % 10;
//            System.out.println("rem = " + rem);
            digits.add(0, rem);
            a /= 10;
        }

//        System.out.println("digits = " + digits);
        HashSet<Integer> products = new HashSet<Integer>();

        // loop through and find contiguous subsequences
        for (int i = 0; i < digits.size(); i++) {
            for (int j = i+1; j <= digits.size(); j++) {
                int product = 1;
                for (int k = i; k < j; k++) {
//                    System.out.println(digits.get(k));
                    product *= digits.get(k);
                }
//                System.out.println("----");
                if (products.contains(product)) {
                    return 0;
                } else {
                    products.add(product);
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(colorful(23));  // expect 1
        System.out.println(colorful(3245));  // expect 1
    }
}
