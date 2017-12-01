package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/21/17.
 *
 * Write a method to replace all whitespaces in a string with #20.
 */

public class ReplaceWhitespace {

    public static String replaceWhitespace(String str, String token) {

        // First, count the number of whitespaces.
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        // Create an array that will hold enough space for the inserted tokens.
        int length = (str.length() - count) + (count * token.length());

        int index = 0;
        char[] updated = new char[length];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                // insert token
                for (int j = 0; j < token.length(); j++) {
                    updated[index++] = token.charAt(j);
                }
            } else {
                updated[index++] = str.charAt(i);
            }
        }

        return new String(updated);
    }

    public static String replaceWhitespace2(String str, String token) {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                buffer.append(token);
            } else {
                buffer.append(str.charAt(i));
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceWhitespace("Write a method to replace all whitespaces in a string.", "#20"));
        System.out.println(replaceWhitespace2("Write a method to replace all whitespaces in a string.", "#20"));
    }
}
