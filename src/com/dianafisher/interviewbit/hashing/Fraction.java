package com.dianafisher.interviewbit.hashing;

/*
* Given two integers representing the numerator and denominator
* of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"

Lets simulate the process of converting fraction to decimal. Lets look at the part where
we have already figured out the integer part which is floor(numerator / denominator).

Now you are left with ( remainder = numerator%denominator ) / denominator.
If you remember the process of converting to decimal, at each step you do the following :

1) multiply the remainder by 10,
2) append remainder / denominator to your decimals
3) remainder = remainder % denominator.

At any moment, if your remainder becomes 0, you are done.

However, there is a problem with recurring decimals. For example if you look at 1/3, the remainder never becomes 0.

Notice one more important thing.
If you start with remainder = R at any point with denominator d, you will always get the same sequence of digits.
So, if your remainder repeats at any point of time, you know that the digits between the last occurrence of R will keep repeating.
* */

import java.util.HashMap;

public class Fraction {
    public String fractionToDecimal(int numerator, int denominator) {
//        System.out.println("------");

        if (numerator == Integer.MIN_VALUE && denominator == -1) return "2147483648";

        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder s = new StringBuilder();

        boolean isNegative = (numerator < 0 && denominator >= 0) || ( numerator >= 0 && denominator < 0);;
        long numer = (long)numerator;
        long denom = (long)denominator;

        numer = Math.abs(numer);
        denom = Math.abs(denom);

        long result = numer / denom;
        long remainder = numer % denom;

        s.append(result);


        if (remainder == 0) {
            return s.toString();
        } else {
            // add decimal point
            s.append('.');
            while (remainder != 0) {
//                System.out.println("remainder = " + remainder);
                if (map.containsKey(remainder)) {
                    int idx = map.get(remainder);
//                    System.out.println("idx = " + idx);
                    String a = s.substring(0, idx);
                    String b = s.substring(idx, s.length());
                    return a + "(" + b + ")";
                }
                map.put(remainder, s.length());
//                System.out.println("remainder = " + remainder);
//                System.out.println("denom = " + denom);
                result = remainder / denom;
//                System.out.println("result = " + result);
                s.append(result);
                remainder = (remainder % denom) * 10;

            }
        }
        if (isNegative) {
            s.insert(0, "-");
        }
        return s.toString();
    }

    public String fractionToDecimal2(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }
        if(denominator == 0) {
            return "";
        }
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        StringBuffer results = new StringBuffer();

        boolean isNeg = (numerator < 0 && denominator >= 0) || ( numerator >= 0 && denominator < 0);
        long num = (long)numerator;
        num = Math.abs(num);

        long den = (long)denominator;
        den = Math.abs(den);

        long q = num/den;
        long r = num%den * 10;
        // System.out.print("q:" + q);

        if(isNeg) {
            //  System.out.print("here:" + q);
            results.append("-");
        }

        results.append(q);

        if(r == 0) {
            return results.toString();
        } else {
            results.append(".");
            while(r != 0) {
                //if digits repeat
                if(map.containsKey(r)) {
                    int start = map.get(r);
                    String part1 = results.toString().substring(0, start);
                    String part2 = results.toString().substring(start, results.length());
                    return part1 + "(" + part2 + ")";
                }

                //continue
                map.put(r, results.length());
                q = r/den;
                results.append(q);
                r = r%den*10;
            }
        }

        return results.toString();

    }

    public static void main(String[] args) {
        Fraction f = new Fraction();
        System.out.println(f.fractionToDecimal(1, 2)); // expect "0.5";
        System.out.println(f.fractionToDecimal(2, 1)); // expect "2";
        System.out.println(f.fractionToDecimal(-1, 2)); // expect "-0.5";
        System.out.println(f.fractionToDecimal(2, 3)); // expect "0.(6)";
        System.out.println(f.fractionToDecimal(-2147483648, -1)); // expect "2147483648";
        System.out.println(f.fractionToDecimal(-1, -2147483648)); // expect "0.0000000004656612873077392578125";
        System.out.println(f.fractionToDecimal(667, 10000)); // expect "0.0000000004656612873077392578125";
    }
}
