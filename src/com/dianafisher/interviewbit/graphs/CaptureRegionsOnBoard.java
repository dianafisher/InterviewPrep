package com.dianafisher.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dianafisher on 1/24/18.
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X


 */
public class CaptureRegionsOnBoard {

    class Cell {
        boolean visited;
        char value;
        int row;
        int col;

        public Cell(int r, int c, char ch) {
            this.row = r;
            this.col = c;
            this.value = ch;
            this.visited = false;
        }

        @Override
        public String toString() {
            return "(" + this.row + ", " + this.col + ") " + this.value + " visited:" + (this.visited ? "YES" : "NO");
//            return this.value + "";
        }
    }

    public void solve(ArrayList<ArrayList<Character>> a) {

        if (a == null) return;

        System.out.println();
        printA(a);
        System.out.println();

        // hunt for an 'O'
        // Once we find an 'O', perform DFS to determine if it is surrounded by 'X'
        // mark each cell as 'visited' to prevent seeing the same cell twice

        int rowCount = a.size();
        int colCount = a.get(0).size();

        ArrayList<ArrayList<Cell>> cells = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            ArrayList<Cell> cellRow = new ArrayList<>();
            for (int j = 0; j < colCount; j++) {
                Cell c = new Cell(i, j, a.get(i).get(j));
                cellRow.add(c);
            }
            cells.add(cellRow);
        }

//        printBoard(cells);

        Queue<Cell> queue = new LinkedList<>();

        // Check borders..
        for (int i = 0; i < colCount; i++) {

            // top row...
            Cell cell = cells.get(0).get(i);
            if (cell.value == 'O') {
                cell.visited = true;
                queue.offer(cell);
            }

            // bottom row...
            cell = cells.get(rowCount-1).get(i);
            if (cell.value == 'O') {
                cell.visited = true;
                queue.offer(cell);
            }
        }

        for (int i = 0; i < rowCount; i++) {
            // left column...
            Cell cell = cells.get(i).get(0);
            System.out.println("checking cell " + cell);
            if (cell.value == 'O') {
                queue.offer(cell);
                cell.visited = true;
            }

            cell = cells.get(i).get(colCount-1);
            if (cell.value == 'O') {
                queue.offer(cell);
                cell.visited = true;
            }
        }

        System.out.println();
        printBoard(cells);
        System.out.println();

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            int row = cell.row;
            int col = cell.col;

            // up
            if (isValidCell(row, col-1, cells)) {
                Cell up = getCellAt(row, col-1, cells);
                if (up.value == 'O') {
                    up.visited = true;
                    queue.offer(up);
                }
            }
            // down
            if (isValidCell(row, col+1, cells)) {
                Cell down = getCellAt(row, col+1, cells);
                if (down.value == 'O') {
                    down.visited = true;
                    queue.offer(down);
                }
            }
            // left
            if (isValidCell(row-1, col, cells)) {
                Cell left = getCellAt(row-1, col, cells);
                if (left.value == 'O') {
                    left.visited = true;
                    queue.offer(left);
                }
            }
            // right
            if (isValidCell(row+1, col, cells)) {
                Cell right = getCellAt(row+1, col, cells);
                if (right.value == 'O') {
                    right.visited = true;
                    queue.offer(right);
                }
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                Cell cell = cells.get(i).get(j);
                if (!cell.visited && cell.value == 'O') {
                    cell.value = 'X';
                    a.get(i).set(j, 'X');
                }
            }
        }

        System.out.println();

        printBoard(cells);
    }

    // A valid cell is within bounds and has not yet been visited.
    private boolean isValidCell(int row, int col, ArrayList<ArrayList<Cell>> cells) {
        if (row < 0) return false;
        if (row > cells.size()-1) return false;

        if (col < 0) return false;
        if (col > cells.get(0).size()-1) return false;

        Cell cell = cells.get(row).get(col);

        return !cell.visited;
    }

    private Cell getCellAt(int row, int col, ArrayList<ArrayList<Cell>> cells) {
        return cells.get(row).get(col);
    }

    private void printBoard(ArrayList<ArrayList<Cell>> board) {
        for (ArrayList<Cell> row : board) {
            System.out.println(row);
        }
    }

    private void printA(ArrayList<ArrayList<Character>> a) {
        for (ArrayList<Character> row : a) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        CaptureRegionsOnBoard c = new CaptureRegionsOnBoard();

        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        board.add(new ArrayList<Character>(Arrays.asList('X', 'X', 'X', 'X')));
        board.add(new ArrayList<Character>(Arrays.asList('X', 'O', 'O', 'X')));
        board.add(new ArrayList<Character>(Arrays.asList('X', 'X', 'O', 'X')));
        board.add(new ArrayList<Character>(Arrays.asList('X', 'O', 'X', 'X')));

        c.solve(board);
        System.out.println(board);

        /*
        * "OOOXXXO", "XXXOOOO", "XXOXOXO", "OXOXOXO", "XXOXOXX", "XOOOXXO", "OXXOXOO", "OXOOXOX"
        * */

        board = new ArrayList<>();
        board.add(new ArrayList<>(Arrays.asList('O', 'O', 'O', 'X', 'X', 'X', 'O')));
        board.add(new ArrayList<>(Arrays.asList('X', 'X', 'X', 'O', 'O', 'O', 'O')));
        board.add(new ArrayList<>(Arrays.asList('X', 'X', 'O', 'X', 'O', 'X', 'O')));
        board.add(new ArrayList<>(Arrays.asList('O', 'X', 'O', 'X', 'O', 'X', 'O')));
        board.add(new ArrayList<>(Arrays.asList('X', 'X', 'O', 'X', 'O', 'X', 'X')));
        board.add(new ArrayList<>(Arrays.asList('X', 'O', 'O', 'O', 'X', 'X', 'O')));
        board.add(new ArrayList<>(Arrays.asList('O', 'X', 'X', 'O', 'X', 'O', 'O')));
        board.add(new ArrayList<>(Arrays.asList('O', 'X', 'O', 'O', 'X', 'O', 'X')));

        c.solve(board);
        System.out.println(board);

    }
}
