package com.dianafisher.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 11/28/17.
 *
 * Given an array of words and a length L, format the text such that each line has exactly
 * L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 *
 * Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 *
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will
 * be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Your program should return a list of strings, where each string represents a single line.
 *
 * Example:
 *
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 *
 * L: 16.
 *
 * Return the formatted lines as:
 *
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 *
 * Note: Each word is guaranteed not to exceed L in length.
 */

public class JustifiedText {

    public static ArrayList<String> fullJustify(ArrayList<String> a, int b) {

        ArrayList<String> result = new ArrayList<String>();

        if (a.size() == 0) return result;

        int count = 0;
        int previous = 0;
        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            count += s.length();

            if (count + i-previous > b) {
                int wordLen = count - s.length();
                int spaceLen = b - wordLen;
                int eachCount = 1;
                int extraSpaces = 0;

                if (i-previous-1 > 0) {
                    eachCount = spaceLen/(i-previous-1);
                    extraSpaces = spaceLen % (i-previous-1);
                }

                StringBuilder builder = new StringBuilder();

                for(int j = previous; j < i-1; j++) {
                    String str = a.get(j);
                    builder.append(str);

                    int ce = 0;
                    while (ce < eachCount) {
                        builder.append(" ");
                        ce++;
                    }

                    // Append extra spaces
                    if (extraSpaces > 0) {
                        builder.append(" ");
                        extraSpaces--;
                    }
                }
                String previousWord = a.get(i-1);
                builder.append(previousWord);

                // if there is only one word..
                while(builder.length() < b) {
                    builder.append(" ");
                }

                result.add(builder.toString());
                previous = i;
                count = s.length();
            }
        }

        // Add the last line of text..
        int lastLen = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = previous; i < a.size()-1; i++) {
            String s = a.get(i);
            count += s.length();
            builder.append(s);
            builder.append(" ");
        }
        // add spaces at the end..
        String s = a.get(a.size()-1);
        builder.append(s);

        while(builder.length() < b) {
            builder.append(" ");
        }
        result.add(builder.toString());

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<String>(Arrays.asList("This", "is", "an", "example", "of", "text", "justification."));
        ArrayList<String> justified = fullJustify(A, 16);
        for (String s : justified) {
            System.out.println(s);
        }

        A = new ArrayList<String>(Arrays.asList("Geeks", "for", "Geeks", "presents", "word", "wrap", "problem"));
        justified = fullJustify(A, 15);
        for (String s : justified) {
            System.out.println(s);
        }

        A = new ArrayList<String>(Arrays.asList("angular"));
        justified = fullJustify(A, 371);
        for (String s : justified) {
            System.out.println(s);
        }

    }
}


