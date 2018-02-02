package com.dianafisher.interviewbit.dynamic_programming.ways_to_decode;

/**
 * Created by dianafisher on 1/31/18.
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26

 Given an encoded message containing digits, determine the total number of ways to decode it.

 Example :

 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.

 */
public class Solution {

    public int numDecodings(String A) {
        if (A == null) return 0;
        int N = A.length();

        int[] dp = new int[N+1];


        int first = Character.getNumericValue(A.charAt(0));
//        System.out.println("first = " + first);
        if (first > 0 && first < 27) {
            dp[0] = 1;
            dp[1] = 1;
        } else {
            return 0;
        }


        for (int i = 2; i<= N; i++) {
            dp[i] = 0;

            // compare char at i with char at i-1;
            char prevPrev = A.charAt(i-2);
            char prev = A.charAt(i-1);

            int pp = Character.getNumericValue(prevPrev);
            int p = Character.getNumericValue(prev);


            // if previous digit is not zero, then add
            if (p > 0) {
                dp[i] = dp[i-1];
            }

            if (pp == 1 || pp == 2 && p < 7) {
                dp[i] += dp[i-2];
            }

            // print dp..
            for (int n = 0; n < dp.length; n++) {
                System.out.print(dp[n] + " ");
            }
            System.out.println();
        }
        return dp[N];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("12"));
        System.out.println(s.numDecodings("1242367"));
        System.out.println(s.numDecodings("1240367"));
        System.out.println(s.numDecodings("10"));
        System.out.println(s.numDecodings("0"));
    }
}
