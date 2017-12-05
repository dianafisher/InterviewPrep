package com.dianafisher.interviewbit.hashing;

import java.util.*;

/**
 * Created by dianafisher on 12/4/17.
 *
 * Given an array of strings, return all groups of strings that are anagrams.
 * Represent a group by a list of integers representing the index in the original list.
 * Look at the sample case for clarification.

 Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
 Note: All inputs will be in lower-case.
 Example :

 Input : cat dog god tca
 Output : [[1, 4], [2, 3]]

 cat and tca are anagrams which correspond to index 1 and 4.
 dog and god are another set of anagrams which correspond to index 2 and 3.
 The indices are 1 based ( the first element has index 1 instead of index 0).

 Ordering of the result : You should not change the relative ordering of the words / phrases within the group.
 Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
 */

public class Anagrams {

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            // anagrams have the same characters, so sort the strings and comparing them
            // sort the characters in the string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String t = new String(chars);
            // check if this sorted string is in the map already
            if (map.containsKey(t)) {
                // add this index (+1) to the array list
                ArrayList<Integer> indexes = map.get(t);
                indexes.add(i+1);
            } else {
                // create a new array list
                ArrayList<Integer> indexes = new ArrayList<Integer>();
                indexes.add(i+1);
                map.put(t, indexes);
            }
        }
//        System.out.println("map = " + map);
        // loop through the map and add to the result array list
        for (String s : map.keySet()) {
            ArrayList<Integer> indexes = map.get(s);
            result.add(indexes);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(anagrams(Arrays.asList("cat", "dog", "god", "tca")));

        System.out.println(anagrams(Arrays.asList( "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba",
        "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa",
                "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab",
                "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb",
                "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab",
                 "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba",
                "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa",
                "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb")));
    }
}
