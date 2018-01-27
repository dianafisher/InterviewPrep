package com.dianafisher.interviewbit.graphs.word_ladder_I;

import java.util.*;

/**
 * Created by dianafisher on 1/26/18.
 *
 * Given two words (start and end), and a dictionary,
 * find the length of shortest transformation sequence from start to end, such that:

 You must change exactly one character in every transformation
 Each intermediate word must exist in the dictionary

 Example :

 Given:

 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]

 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note that we account for the length of the transformation path instead of the number of transformation itself.

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.


 */
public class Solution {

    public int ladderLength(String start, String end, ArrayList<String> dictV) {

        if (start.equals(end)) return 1;

        if (differByOneLetter(start, end)) return 2;

        // start with start..
        int count = 1;

        // Shortest path -> BFS (so use a queue)
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            Queue<String> queue2 = new LinkedList<>();
            while (!queue.isEmpty()) {

                String current = queue.poll();

                if (differByOneLetter(current, end)) {
                    return count + 1;
                }

                for (String s : dictV) {
                    if (differByOneLetter(current, s)) {
                        queue2.offer(s);
                    }
                }

                for (String s :queue2) {
                    dictV.remove(s);
                }
            }
            queue.addAll(queue2);
            count++;

        }

        return 0;
    }

    private boolean differByOneLetter(String A, String B) {
        System.out.println("comparing " + A + " with " + B);
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }
        System.out.println("count = " + count);
        return (count == 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = s.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log")));
        System.out.println("n = " + n);
    }
}
