package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/21/17.
 */
public class Substrings {

    public static boolean isSubstring(String a, String b) {
        if (a.length() < b.length()) {
            return b.contains(a);
        }

        return a.contains(b);
    }


    /*
    * This is often an easy lead up to String rotations and the next question will likely be:
    * “Now check if one string is a rotation of another.”
    * For example, “forinterviewscoding”, “interviewscodingfor” and “dingforinterviewsco”
    * are all valid rotations of the string “codingforinterviews”, while “codngiforinterviews” is not.
    *
    * The key to this is observing that the original string is a substring of the rotated string added to itself.
    *
    * Comparing lengths of two strings takes O(n) time.
    *
    * Java's contains() method takes O(n) time.
    * */

    public static boolean isRotation(String a, String b) {
        if (a.length() != b.length()) return false;

        return isSubstring(a+a, b);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("forinterviewscoding", "codingforinterviews"));
        System.out.println(isRotation("codngiforinterviews", "codingforinterviews"));
    }
}

