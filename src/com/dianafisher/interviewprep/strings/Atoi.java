package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/24/17.
 *
 * Questions:
 Q1. Does string contain whitespace characters before the number?
 A. Yes

 Q2. Can the string have garbage characters after the number?
 A. Yes. Ignore it.

 Q3. If no numeric character is found before encountering garbage characters, what should I do?
 A. Return 0.

 Q4. What if the integer overflows?
 A. Return INT_MAX if the number is positive, INT_MIN otherwise.
 */
public class Atoi {

    public static int atoi(final String a) {
//        System.out.println("-------");
        if (a.length() == 0) return 0;
        int index = 0;
        int result = 0;
        int maxDivTen = Integer.MAX_VALUE / 10;
        int sign = 1;

        // ignore leading whitespace
        while (a.charAt(index) == ' ') {
            index++;
        }

        // Look for + or - sign
        char ch = a.charAt(index);
        if (ch == '-') {
            sign = -1;
            index++;
        } else if (ch == '+') {
            index++;
        }

        while (index < a.length()) {
            ch = a.charAt(index);
            int value = (int)ch - (int)'0';
            if (value >= 0 && value <= 9) {
                if (result > maxDivTen || result == maxDivTen && value > 7) {
                    if (sign < 0) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                } else {
                    result = result * 10 + value;
//                    System.out.println("result = " + result);
                }
            } else {
                // invalid character, break out of loop
//                System.out.println("invalid character '" + ch + "'");
                break;
            }
            index++;
        }

        return sign * result;
    }

    static boolean isDigit(char ch) {
        int value = (int)ch;
        value -= (int)'0';
        if (value >= 0 && value <= 9) {
            return true;
        }
        return false;
    }

    static final int safeAdd(int a, long b) throws ArithmeticException {

        long result = ((long) a) + b;

        if (result > Integer.MAX_VALUE) {
            throw new RuntimeException("Overflow occured");
        } else if (result < Integer.MIN_VALUE) {
            throw new RuntimeException("Underflow occured");
        }
        return (int)result;
    }

    public static void main(String[] args) {

        System.out.println(atoi("9 2704"));  // expect 9
        System.out.println(atoi("2704"));  // expect 2704           // 2*1000 + 7*100 + 0*10 + 4*1
        System.out.println(atoi("-2704"));  // expect -2704
        System.out.println(atoi(" 2704"));  // expect 2704
        System.out.println(atoi(" -2704"));  // expect -2704
        System.out.println(atoi(" -2 704"));  // expect -2
        System.out.println(atoi("      -2 704"));  // expect -2
        System.out.println(atoi(" abc -704"));  // expect 0
        System.out.println(atoi("abc -704"));  // expect 0
        System.out.println(atoi("2a704"));  // expect 2
        System.out.println(atoi("+7"));  // expect 7
        System.out.println(atoi("-54332872018247709407 4 54"));  // expect -2147483648
        System.out.println(atoi("V515V 5793K 627 23815945269 1 1249794L 631 8755 7")); // 0
        System.out.println(atoi("- 5 88C340185Q 71 8079 834617385 2898422X5297Z6900"));  // expect 0
        System.out.println(atoi("5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393"));  // expect 2147483647
        System.out.println(atoi("-5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393"));  // expect -2147483647
    }
}
