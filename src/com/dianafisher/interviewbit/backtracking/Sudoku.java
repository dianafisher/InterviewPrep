package com.dianafisher.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 1/16/18.
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Given:
 * [
 * [53..7....],
 * [6..195...],
 * [.98....6.],
 * [8...6...3],
 * [4..8.3..1],
 * [7...2...6],
 * [.6....28.],
 * [...419..5],
 * [....8..79]
 * ]
 *
 * expect
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 *
 * 1. Find empty cell
 * 2. Loop from 1 to 9
 * 3.
 */
public class Sudoku {


    public void solveSudoku(ArrayList<ArrayList<Character>> a) {

        printBoard(a);

        puzzleSolver(a);

        printBoard(a);
    }

    private boolean puzzleSolver(ArrayList<ArrayList<Character>> board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ArrayList<Character> row = board.get(i);
                if (row.get(j) == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(i, j, ch, board)) {
                            row.set(j, ch);

                            if (puzzleSolver(board)) {
                                return true;
                            }
                            row.set(j, '.');
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int r, int c, char target, ArrayList<ArrayList<Character>> board) {
        // check row and column
        ArrayList<Character> row = board.get(r);
        if (row.contains(target)) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            row = board.get(i);
            if (row.get(c) == target) {
                return false;
            }
        }

        // check sub-grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = r / 3 * 3 + i;
                int y = c / 3 * 3 + j;

                row = board.get(x);
                if (row.get(y) == target) {
                    return false;
                }
            }
        }
        return true;
    }

    private void printBoard(ArrayList<ArrayList<Character>> board) {
        System.out.println("BOARD:");
        for (ArrayList<Character> row : board) {
            System.out.println(row);
        }
    }



    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        ArrayList<Character> r1 = new ArrayList<>(Arrays.asList('5', '3', '.', '.', '7', '.', '.', '.', '.'));
        ArrayList<Character> r2 = new ArrayList<>(Arrays.asList('6', '.', '.', '1', '9', '5', '.', '.', '.'));
        ArrayList<Character> r3 = new ArrayList<>(Arrays.asList('.', '9', '8', '.', '.', '.', '.', '.', '.'));
        ArrayList<Character> r4 = new ArrayList<>(Arrays.asList('8', '.', '.', '.', '6', '.', '.', '.', '3'));
        ArrayList<Character> r5 = new ArrayList<>(Arrays.asList('4', '.', '.', '8', '.', '3', '.', '.', '1'));
        ArrayList<Character> r6 = new ArrayList<>(Arrays.asList('7', '.', '.', '.', '2', '.', '.', '.', '6'));
        ArrayList<Character> r7 = new ArrayList<>(Arrays.asList('.', '6', '.', '.', '.', '.', '2', '8', '.'));
        ArrayList<Character> r8 = new ArrayList<>(Arrays.asList('.', '.', '.', '4', '1', '9', '.', '.', '5'));
        ArrayList<Character> r9 = new ArrayList<>(Arrays.asList('.', '.', '.', '.', '8', '.', '.', '7', '9'));

        board.add(r1);
        board.add(r2);
        board.add(r3);
        board.add(r4);
        board.add(r5);
        board.add(r6);
        board.add(r7);
        board.add(r8);
        board.add(r9);

        s.solveSudoku(board);
    }
}
