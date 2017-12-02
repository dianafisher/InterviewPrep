package com.dianafisher.interviewbit.strings;

/**
 * Created by dianafisher on 12/2/17.
 *
 * Given two binary strings, return their sum (also a binary string).

 Example:

 a = "100"

 b = "11"
 Return a + b = “111”.

 In binary...
 0 + 0 = 0
 0 + 1 = 1
 1 + 0 = 1
 1 + 1 = 10 (which is 0, carry 1)
 1 + 1 + 1 = 1 (carry 1)

 1010
   11
 ____
 1101

 100101
  10101
 ______
 111010

 1000011011000000111100110
 0001010110111001101101000
 _________________________
 0000000000000000001001110
 */
public class AddBinaryStrings {

    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();

        StringBuilder ba = new StringBuilder(a);
        StringBuilder bb = new StringBuilder(b);

        // pad the shorter string with leading zeroes.
        if (ba.length() > bb.length()) {
            while (bb.length() < ba.length()) {
                bb.insert(0, '0');
            }
        } else if (bb.length() > ba.length()) {
            while (ba.length() < bb.length()) {
                ba.insert(0, '0');
            }
        }
//        System.out.println("ba = " + ba);
//        System.out.println("bb = " + bb);

        int carry = 0;
        int N = ba.length();
        for (int i = N-1; i > -1; i--) {
            int na = (int)ba.charAt(i) - (int)'0';
            int nb = (int)bb.charAt(i) - (int)'0';

//            System.out.println(na + " + " + nb + " + carry = " + carry);

            if (na == 1 && nb == 1) {
                if (carry == 1) {
                    builder.insert(0, "1");
                    carry = 1;
                } else {
                    builder.insert(0, "0");
                    carry = 1;
                }
            } else if (na == 0 && nb == 0) {
                int sum = na + nb + carry;
                builder.insert(0, sum);
                carry = 0;
            } else {
                if (carry == 1) {
                    builder.insert(0, "0");
                    carry = 1;
                } else {
                    builder.insert(0, "1");
                }
            }
        }
        if (carry > 0) {
            builder.insert(0, '1');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("100", "11"));  // 111
        System.out.println(addBinary("1010", "11"));  // 1101
        System.out.println(addBinary("100101", "10101"));  // 111010
        System.out.println(addBinary("111", "111"));  // 1110
        System.out.println(addBinary("1010110111001101101000", "1000011011000000111100110"));  //1001110001111010101001110
    }
}
