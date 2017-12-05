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


    public static ArrayList<Integer> oldSolution(final List<Integer> a, int b) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a == null || a.size() == 0) return result;

        // Create a hashmap to hold matches (key = index2, value = list of index1)
        HashMap<Integer, ArrayList<Integer>> matches = new HashMap<Integer, ArrayList<Integer>>();

        // Find two numbers in a such that they add up to b.
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                if (sum == b) {
//                    System.out.println("index " + i + " + index " + j);
                    if (matches.containsKey(j)) {
                        matches.get(j).add(i);
                    } else {
                        ArrayList<Integer> indices = new ArrayList<Integer>();
                        indices.add(i);
                        matches.put(j, indices);
                    }
                }
            }
        }

//        System.out.println(matches);
        // Find solution where index2 is minimum.
        int minIndex2 = Integer.MAX_VALUE;
        for (Integer index2 : matches.keySet()) {
            if (index2 < minIndex2) {
                minIndex2 = Math.min(minIndex2, index2);
            }
        }

//        System.out.println("minIndex2 = " + minIndex2);
        ArrayList<Integer> index1s = matches.get(minIndex2);
        if (index1s != null) {
            if (index1s.size() > 1) {
                // find the minimum index 1
                int minIndex1 = Integer.MAX_VALUE;
                for (Integer i : index1s) {
                    minIndex1 = Math.min(minIndex1, i);
                }
                result.add(minIndex1+1);
                result.add(minIndex2+1);
            } else if (index1s.size() == 1){
                result.add(index1s.get(0)+1);
                result.add(minIndex2+1);
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


