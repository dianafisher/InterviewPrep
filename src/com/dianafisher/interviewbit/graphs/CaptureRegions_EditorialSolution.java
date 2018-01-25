package com.dianafisher.interviewbit.graphs;

import java.util.ArrayList;

/**
 * Created by dianafisher on 1/24/18.
 */
public class CaptureRegions_EditorialSolution {

    public void solve(ArrayList<ArrayList<Character>> a) {
	    /*
	    starting from the boundaries of the array, dfs from each 'O' on the boundaries, changing
	    all connecting 'O's to a dummy character such as 'R'.

	    Then afterwards, loop through
	    the entire array and change the 'O's to 'X'.

	    Then loop through the entire array again
	    and change the 'R's back to 'X's.
	    */
        int maxRow = a.size()-1;
        int maxCol = a.get(0).size()-1;
        for (int i = 0; i <= maxRow; i++) {
            dfs(a, i, 0);
        }
        for (int j = 0; j <= maxCol; j++) {
            dfs(a, 0, j);
        }
        for (int i = 0; i <= maxRow; i++) {
            dfs(a, i, maxCol);
        }
        for (int j = 0; j <= maxCol; j++) {
            dfs(a, maxRow, j);
        }
        //now change all the 'O's to 'X's
        for (int i = 0; i <= maxRow; i++) {
            for (int j = 0; j <= maxCol; j++) {
                if (a.get(i).get(j) != 'R') {
                    a.get(i).set(j, 'X');
                }
            }
        }
        //now change all the 'R's back to 'O's
        for (int i = 0; i <= maxRow; i++) {
            for (int j = 0; j <= maxCol; j++) {
                if (a.get(i).get(j) == 'R') {
                    a.get(i).set(j, 'O');
                }
            }
        }
    }

    public void dfs(ArrayList<ArrayList<Character>> a, int r, int c) {
        if (r < 0 || r >= a.size() || c < 0 || c >= a.get(r).size() || a.get(r).get(c) != 'O') return;

        a.get(r).set(c, 'R');

        dfs(a, r+1, c);
        dfs(a, r, c+1);
        dfs(a, r-1, c);
        dfs(a, r, c-1);
    }
}
