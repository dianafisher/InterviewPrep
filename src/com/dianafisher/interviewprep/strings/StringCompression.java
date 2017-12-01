package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/22/17.
 */

public class StringCompression {

    public static int compressedLength(String str) {
        int length = 0;  // string length

        int count = 1;  // count for each character

        char current = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == current) {
               count++;
            } else {
                current = str.charAt(i);
                length += 1 + String.valueOf(count).length();
                count = 1;
            }
        }

        // handle the last character in the string
        length += 1 + String.valueOf(count).length();
        return length;
    }

    public static String compressString(String str) {

        int compressedLen = compressedLength(str);
        if (compressedLen >= str.length()) {
            return str;
        }

        StringBuffer buffer = new StringBuffer();
        int count = 1;
        char current = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == current) {
                count++;
            } else {
                buffer.append(current);
                buffer.append(count);
                current = ch;
                count = 1;
            }
        }

        // handle last character in string
        buffer.append(current);
        buffer.append(count);

        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaabbbcccc"));
        System.out.println(compressString("abcdef"));
    }
}
