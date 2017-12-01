package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/21/17.
 *
 */

public class ReverseString {

    /*
    * Reverses input string x in linear time by using a StringBuffer
    * */
    public static String reverse(String x) {

        char[] string = x.toCharArray();
        StringBuffer buffer = new StringBuffer();

        for (int i = string.length - 1; i > -1; i--) {
            buffer.append(string[i]);
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String s = reverse("elements");
        System.out.println(s);
    }
}
