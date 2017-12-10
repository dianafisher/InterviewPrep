package com.dianafisher.interviewbit.hashing;

/*
* Given an array A of integers and another non negative integer k,
* find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Diffk2 {

    public int diffPossible(final List<Integer> a, int b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Add all of the values to a map.
        for (int i = 0; i < a.size(); i++) {
            map.put(a.get(i), i);
        }

        // For each value a[i] in the list, look for a[i] + b.
        for (int i = 0; i < a.size(); i++) {
            int sum = a.get(i) + b;
            if (map.containsKey(sum)) {
                Integer idx = map.get(sum);
                if (idx != i) {
                    return 1;
                }
            }
        }



        return 0;
    }

    public static void main(String[] args) {

        Diffk2 diffk2 = new Diffk2();

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 3));
        System.out.println(diffk2.diffPossible(list, 2));

        list = new ArrayList<>(Arrays.asList(11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13));
        System.out.println(diffk2.diffPossible(list, 60));
    }
}
