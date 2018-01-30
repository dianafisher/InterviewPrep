package com.dianafisher.interviewbit.dynamic_programming.jump_game_array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dianafisher on 1/29/18.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return 1 ( true ).

 A = [3,2,1,0,4], return 0 ( false ).

 Return 0/1 for this problem

 */
public class Solution {

    public int canJump(ArrayList<Integer> A) {

        if (A == null) return 0;
        if (A.size() == 0) return 0;

        int N = A.size();

        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[i] = A.get(i);
            } else {
                if (dp[i-1] == 0) return 0; // cannot move any further
                else {
                    dp[i] = Math.max(dp[i-1]-1, A.get(i));
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i]);
//            if (i < dp.length-1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println();

        return 1;
    }

    public int canJump_Editorial(ArrayList<Integer> a) {
        int currJump= 0;
        for (int i=0; i<a.size(); i++){
            if (currJump<0) return 0;
            currJump= Math.max(a.get(i),currJump);
            currJump--;
        }
        return 1;
    }

    public int canJump_Fastest(ArrayList<Integer> a) {

        int steps=a.get(0);
        for(int i=1;i<a.size();i++)
        {
            steps--;
            if(steps<0)
                return 0;

            if(a.get(i)>steps)
                steps=a.get(i);
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new ArrayList<>(Arrays.asList(2, 3, 1, 1, 4))));
        System.out.println(s.canJump(new ArrayList<>(Arrays.asList(3, 2, 1, 0, 4))));
    }
}
