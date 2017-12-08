package com.dianafisher.interviewbit.hashing;

/*
* Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

* */

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class ValidSudoku {

    // Returns 0 for false and 1 for true.
    public int isValidSudoku(final List<String> a) {
//        for (String s : a) {
//            System.out.println(s);
//        }

        int gridSize = a.size();
//        System.out.println("gridSize = " + gridSize);
        int subGridSize = gridSize / 3;
//        System.out.println("subGridSize = " + subGridSize);
        // check board rows..
        for (String s : a) {
            if (isValidRow(s) != 1) {
                return 0;
            }
        }

        // check board columns
        for (int i = 0; i < gridSize; i++) {
            int[] nums = new int[9];
            for (String s : a) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    int value = (int)ch - (int)'0';
                    nums[value-1]++;
                    if (nums[value-1] > 1) {
//                        System.out.println("duplicate " + value + " found in column " + i);
                        return 0;
                    }
                }
            }
        }

        // check sub grids..
        for (int i = 0; i < gridSize; i+= subGridSize) {
            for (int j = 0; j < gridSize; j+= subGridSize) {
                int[] nums = new int[9];
                for (int k = 0; k < subGridSize; k++) {
                    for (int m = 0; m < subGridSize; m++) {
                        int x = i + k;
                        int y = j + m;
                        char ch = a.get(x).charAt(y);
                        if (Character.isDigit(ch)) {
//                            System.out.println("ch = " + ch);
                            int value = (int)ch - (int)'0';
                            nums[value-1]++;
                            if (nums[value-1] > 1) {
                                return 0;
                            }
                        }
                    }
                }
            }
        }

        return 1;
    }


    private int isValidRow(String s) {
        int[] nums = new int[9];
        for (char ch : s.toCharArray()) {
            if (ch != '.') {
                if (Character.isDigit(ch)) {
                    int value = (int)ch - (int)'0';
                    nums[value-1]++;
                    if (nums[value-1] > 1) {
//                        System.out.println("duplicate " + value + " found in " + s);
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        ArrayList<String> board = new ArrayList<>(Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"));
        ValidSudoku vs = new ValidSudoku();
        vs.isValidSudoku(board);
    }
}
