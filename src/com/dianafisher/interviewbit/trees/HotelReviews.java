package com.dianafisher.interviewbit.trees;

/*
* Given a set of reviews provided by the customers for different hotels and a
* string containing “Good Words”, you need to sort the reviews in descending
* order according to their “Goodness Value” (Higher goodness value first).
* We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same
“Goodness Value” then their original order would be preserved.

 You are expected to use Trie in an Interview for such problems

 Unlike a binary search tree, no node in the tree stores the key associated with that node;
 instead, its position in the tree defines the key with which it is associated. All the
 descendants of a node have a common prefix of the string associated with that node, and
 the root is associated with the empty string.

 Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)

Input:

S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.

Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews.

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order.
(Indexing is 0 based)

Example:

Input:
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]


* */

import java.util.*;

class TrieNode {
    char value;
    HashMap<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode(char ch) {
        this.value = ch;
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode((char)0);
    }

    public void insert(String word) {
        // find the length of the word
        int length = word.length();
        TrieNode node = root;

        // traverse through the characters of a given word
        for (int level = 0; level < length; level++) {
            HashMap<Character, TrieNode> children = node.children;
            char ch = word.charAt(level);

            if (children.containsKey(ch)) {
                node = children.get(ch);
            } else {
                // create a new child for this character
                TrieNode temp = new TrieNode(ch);
                children.put(ch, temp);
                node = temp;
            }
        }

        node.isEnd = true;
    }

    public boolean contains(String key) {
        int level;
        int length = key.length();

        TrieNode node = root;

        for (level = 0; level < length; level++) {
            char ch = key.charAt(level);
//            System.out.println("ch = " + ch);
            if (!node.children.containsKey(ch)) {
                return false;
            }

            node = node.children.get(ch);  // move down the trie
        }

        return (node != null && node.isEnd);
    }

}

class Review {
    int index;
    int score;

    Review(int index, int score) {
        this.index = index;
        this.score = score;
    }

    @Override
    public String toString() {
        return "index: " + index + ", score: " + score;
    }
}

public class HotelReviews {

    /*
    * The goodness value of a string is the number of "good words" in that string.
    * */
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        ArrayList<Integer> result = new ArrayList<>();
        Trie trie = new Trie();

        // Add each 'good' word to the trie.
        String[] goodWords = A.split("_");
        for (String w : goodWords) {
//            System.out.println(w);
            trie.insert(w);
        }

        ArrayList<Integer> scores = new ArrayList<>();
        PriorityQueue<Review> queue = new PriorityQueue<>(new Comparator<Review>() {
            @Override
            public int compare(Review r1, Review r2) {
                if (r1.score > r2.score) { return -1; }
                else if (r1.score < r2.score) { return 1; }
                else {
                    if (r1.index < r2.index) {
                        return -1;
                    } else if (r1.index > r2.index) {
                        return 1;
                    }
                    return 0;
                }
            }
        });

        // For each string in the review, check if the trie contains it.
        for (int i = 0; i < B.size(); i++) {
            String review = B.get(i);
            String[] words = review.split("_");
            int score = 0;
            for (String w : words) {
//                System.out.println("w = " + w);
                if (trie.contains(w)) {
                    score++;
                }
            }
//            System.out.println("review: " + review + ", score = " + score);
            scores.add(score);
            Review r = new Review(i, score);
            queue.add(r);
        }

//        System.out.println("scores = " + scores);
//        System.out.println("queue = " + queue);

        while (!queue.isEmpty()) {
            Review r = queue.poll();
            result.add(r.index);
        }

        return result;
    }


    public static void main(String[] args) {
        HotelReviews hr = new HotelReviews();
        ArrayList<String> reviews = new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"));
        ArrayList<Integer> result = hr.solve("cool_ice_wifi", reviews);
        System.out.println(result);  // expect [2, 0, 1]

    }
}
