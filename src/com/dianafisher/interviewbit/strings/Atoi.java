package com.dianafisher.interviewbit.strings;

/**
 * Created by dianafisher on 12/2/17.
 * Implement atoi to convert a string to an integer.

 Example :

 Input : "9 2704"
 Output : 9
 */
public class Atoi {
    public int atoi(final String a) {
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
}
