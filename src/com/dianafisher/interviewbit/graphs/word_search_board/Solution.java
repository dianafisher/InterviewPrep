package com.dianafisher.interviewbit.graphs.word_search_board;

import java.util.ArrayList;

/**
 * Created by dianafisher on 1/26/18.
 *
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The cell itself does not count as an adjacent cell.
 The same letter cell may be used more than once.

 Example :

 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]

 word = "ABCCED", -> returns 1,
 word = "SEE", -> returns 1,
 word = "ABCB", -> returns 1,
 word = "ABFSAB" -> returns 1
 word = "ABCD" -> returns 0

 Note that 1 corresponds to true, and 0 corresponds to false.
 */

public class Solution {

    public int exist(ArrayList<String> A, String B) {

        if (A == null || A.size() == 0) return 0;

        int n = A.size();
        int m = A.get(0).length();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).charAt(j) == B.charAt(idx)) {
                    // found first character, so start looking for the rest
                    if (findWord(B, idx, A, i, j)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }


    private boolean findWord(String word, int idx, ArrayList<String> board, int i, int j) {

        if(i < 0 || i >= board.size() || j < 0 || j >= board.get(i).length()) {
            return false;
        }

        if (word.length() == idx) return true;

        if (word.charAt(idx) != board.get(i).charAt(j)) return false;

        // left
        if (findWord(word, idx+1, board, i-1, j)) return true;

        // right
        if (findWord(word, idx+1, board, i+1, j)) return true;

        // up
        if (findWord(word, idx+1, board, i, j-1)) return true;

        // down
        if (findWord(word, idx+1, board, i, j+1)) return true;

        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        ArrayList<String> board = new ArrayList<>();
        board.add("ABCE");
        board.add("SFCS");
        board.add("ADEE");

        System.out.println(s.exist(board, "ABCCED"));  // 1
        System.out.println(s.exist(board, "SEE"));  // 1
        System.out.println(s.exist(board, "ABCB"));  // 1
        System.out.println(s.exist(board, "ABFSAB"));  // 1
        System.out.println(s.exist(board, "ABCD"));  // 0
    }
}
