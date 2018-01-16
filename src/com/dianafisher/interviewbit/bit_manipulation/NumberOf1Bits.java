package com.dianafisher.interviewbit.bit_manipulation;

/**
 * Created by dianafisher on 1/15/18.
 *
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.

 Example:

 The 32-bit integer 11 has binary representation

 00000000000000000000000000001011
 so the function should return 3.

 Note that since Java does not have unsigned int, use long for Java

 */
public class NumberOf1Bits {

    public int numSetBits(long a) {

        int count = 0;
        while (a > 0) {
            count += a & 1;
            // alternative: count += a % 2;
            a >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits n = new NumberOf1Bits();
        System.out.println(n.numSetBits(11));  // returns 3;
    }
}
