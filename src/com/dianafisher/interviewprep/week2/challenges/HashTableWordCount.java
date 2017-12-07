package com.dianafisher.interviewprep.week2.challenges;

/* Hash table word count
* Write a program which takes as its input a String of natural language text and outputs a
* HashMap<String,Integer> whose keys are the unique words in the input and whose values are
* the number of times those words occur. The algorithm should be case-insensitive (e.g.
* "Program" and "program" would count as the same word) and ignore punctuation and whitespace.

* Example: Given the input "To be or not to be, that is the question", the outputted HashMap
* would contain 8 entries, with two words having a count of 2 and six words having a count of 1:
*
* */

import java.util.HashMap;

public class HashTableWordCount {

    public HashMap<String, Integer> wordCount(String text) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        if (text.length() == 0) return map;

        // Split the string into individual words.
        String[] words = text.split(" ");

        for (String w : words) {
            System.out.println(w);
        }

        // Loop through the list of words and add them to the map.
        for (String w : words) {
            // ignore case and punctuation..
            w = w.toLowerCase();
            StringBuilder builder = new StringBuilder();
            for (char ch : w.toCharArray()) {
                if (Character.isLetterOrDigit(ch)) {
                    builder.append(ch);
                }
            }
            String key = builder.toString();
            if (map.containsKey(key)) {
                Integer count = map.get(key);
                count += 1;
                map.put(key, count);
            } else {
                map.put(key, 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        HashTableWordCount solution = new HashTableWordCount();
        HashMap<String, Integer> map = solution.wordCount("To be or not to be, that is the question");
        System.out.println(map);
    }
}
