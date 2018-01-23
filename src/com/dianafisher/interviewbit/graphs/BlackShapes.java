package com.dianafisher.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 1/22/18.
 *
 * Given N * M field of O's and X's, where O=white, X=black
 Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

 Example:

 OOOXOOO
 OOXXOXO
 OXOOOXO

 answer is 3 shapes are  :
 (i)    X
 X X
 (ii)
 X
 (iii)
 X
 X
 Note that we are looking for connected shapes here.

 For example,

 XXX
 XXX
 XXX
 is just one single connected black shape.


 */
public class BlackShapes {

    int deltaN[] = new int[]{1, -1, 0, 0};
    int deltaM[] = new int[]{0, 0, 1, -1};

    public int black(ArrayList<String> A) {
        if (A == null || A.size() == 0) return 0;

        int N = A.size();  // cols
        int M = A.get(0).length(); // rows

        int count = 0;

        boolean[][] visited = new boolean[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (!visited[n][m] && A.get(n).charAt(m) == 'X') {
                    // perform depth first search
                    dfs(m, n, M, N, visited, A);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int m, int n, int M, int N, boolean[][] visited, ArrayList<String> A) {
        visited[n][m] = true;
        // move in all four directions: up, down, left, right
        for (int i = 0; i < 4; i++) {
            int nn = n + deltaN[i];
            int mm = m + deltaM[i];

            if (isValid(mm, nn, M, N, A) && !visited[nn][mm]) {
                dfs(mm, nn, M, N, visited, A);
            }

        }
    }

    private boolean isValid(int m, int n, int M, int N, ArrayList<String> A) {
        if (m < 0 || m >= M) return false;
        if (n < 0 || n >= N) return false;

        if (A.get(n).charAt(m) != 'X') return false;
        return true;
    }

    public static void main(String[] args) {
        BlackShapes bs = new BlackShapes();
        ArrayList<String> board = new ArrayList<>(Arrays.asList("OOOXOOO", "OOXXOXO", "OXOOOXO"));
        System.out.println(bs.black(board));

    }
}
