package com.dianafisher.interviewbit.hashing;

import java.util.*;

/**
 * Created by dianafisher on 12/4/17.
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
 Put both these numbers in order in an array and return the array from your function ( Looking at the
 function signature will make things clearer ). Note that, if no pair exists, return empty list.

 If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with
 the minimum index2, choose the one with minimum index1 out of them.

 Input: [2, 7, 11, 15], target=9
 Output: index1 = 1, index2 = 2

 2 + 7
 2 + 11
 2 + 15
 7 + 2 (done already)
 7 + 11
 7 + 15
 11 + 15


 */

public class TwoSum {
    public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a == null || a.size() < 2) return result;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        /*
        * For each integer n in the list, check if the map contains (b-n).
        * If yes, then we have our result.
        * Otherwise, if the map does not contain n, add it to the map.
        *
        * idx = 0, n = 2  -> map empty
        * idx = 1, n = 7  -> map contains 2 which is equal to (b-n) => FOUND
        *
        * A = [8, 11, 15, 8, 7, 2, 1, 1], b = 9
        *
        * idx = 0, n = 8  -> b-n = -1, map empty
        * idx = 1, n = 11 -> b-n = -2, map contains 8 which is NOT equal to (b-n)
        * idx = 2, n = 15 -> b-n = -6, map contains 8, 11
        * idx = 3, n = 8  -> b-n = -1, map contains 8, 11, 15
        * idx = 4, n = 7  -> b-n = 2, map contains 8, 11, 15, 7
        * idx = 5, n = 2  -> b-n = 7, found in map, return [4+1,5+1]
        *
        * */

        for (int i = 0; i < a.size(); i++) {
            int n = a.get(i);
            int diff = b-n;
            if (map.containsKey(diff)) {
                int idx = map.get(diff);
                result.add(idx);
                result.add(i+1);
                return result;
            } else if (!map.containsKey(n)) {
                map.put(n, i+1);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        ArrayList<Integer> res = twoSum(Arrays.asList(2, 7, 11, 15), 9);
        System.out.println(res);    // expect [1, 2]

        System.out.println(twoSum(Arrays.asList(8, 11, 15, 7, 2, 1), 9));   // expect [4, 5]
        System.out.println(twoSum(Arrays.asList(8, 11, 15, 8, 7, 2, 1, 1), 9));   // expect [5, 6]
        System.out.println(twoSum(Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8), -3));   // expect [4, 8]
        System.out.println(twoSum(Arrays.asList(-10, -10, -10), -5));   // expect []
    }
}


