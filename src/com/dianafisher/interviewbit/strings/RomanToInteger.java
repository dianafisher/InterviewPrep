package com.dianafisher.interviewbit.strings;

import java.util.HashMap;

/**
 * Created by dianafisher on 12/2/17.
 *
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 Read more details about roman numerals at Roman Numeric System

 Example :

 Input : "XIV"
 Return : 14

 Input : "XX"
 Output : 20

 */
public class RomanToInteger {

    public static int romanToInt(String a) {

        HashMap<Character, Integer> values = new HashMap<Character, Integer>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int result = 0;

        int i = 0;
        while (i < a.length()) {
            char ch = a.charAt(i);
            int val = values.get(ch);

            if (ch == 'I' || ch == 'X' || ch == 'C') {
                if (i < a.length()-1) {
                    char next = a.charAt(i+1);
                    if (ch == 'I' && next == 'V' ||
                        ch == 'X' && next == 'L' ||
                        ch == 'C' && next == 'D') {
                        result += (val * 4);
                        i++;
                    } else if (ch == 'I' && next =='X' ||
                                ch == 'X' && next =='C' ||
                                ch == 'C' && next =='M') {
                        result += (val * 9);
                        i++;
                    } else {
                        result += val;
                    }
                } else {
                    result += val;
                }
            } else {
                result += val;
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XIV"));  // expect 14
        System.out.println(romanToInt("XX"));  // expect 20
        System.out.println(romanToInt("II"));  // expect 2
        System.out.println(romanToInt("IX"));  // expect 9
        System.out.println(romanToInt("VIII"));  // expect 8
        System.out.println(romanToInt("IV"));  // expect 4
        System.out.println(romanToInt("MMMCMXCIX"));  // expect 3999
        System.out.println(romanToInt("C"));  // expect 100
        System.out.println(romanToInt("CD"));  // expect 400
        System.out.println(romanToInt("M"));  // expect 1000
        System.out.println(romanToInt("CM"));  // expect 900
        System.out.println(romanToInt("XC"));  // expect 90
    }
}
