package com.dianafisher.interviewbit.graphs.possibility_of_finishing_all_courses_given_prerequisites;

import java.util.*;


/**
 * Created by dianafisher on 1/25/18.
 *
 * There are a total of N courses you have to take, labeled from 1 to N.
 * Some courses may have prerequisites, for example to take course 2 you
 * have to first take course 1, which is expressed as a pair: [1,2].
 *
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses. return 1/0 if it is possible/not possible.
 The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].

 Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], then you can finish courses in the following
 order: 1, 2 and 3. But if N = 2 and the prerequisite pairs are [1,2] and [2,1],
 then it is not possible for you to finish all the courses.

 */
public class Solution {

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int N = A;  // have to take N courses, labeled 1 to N.

        Map<Integer, Integer> courseMap = new HashMap<>();

        // Have to take B[i] before C[i]

        /*
        *  1 -> 2
        *  3 -> 1
        *  4 -> 5
        *  5 -> 3
        *
        *  for course 1..
        *  need 3
        *
        *  for course 3, need 5
        *  for course 5, need 4
        *  need nothing before 4
        *
        *  4 -> 5 -> 3 -> 1 -> 2
        *
        * */

        for (int i = 0; i < C.size(); i++) {
            int course = C.get(i);
            int prereq = B.get(i);

            courseMap.put(prereq, course);
        }
        System.out.println(courseMap);

        for (int i = 1; i <= N; i++) {
            if (containsCycle(i, courseMap, new HashSet<>())) {
                return 0;
            }
        }

        return 1;
    }

    private boolean containsCycle(int course, Map<Integer, Integer> courseMap, Set<Integer> visited) {
        if (visited.contains(course)) return true;

        visited.add(course);
        if (courseMap.containsKey(course)) {
            int preReq = courseMap.get(course);
            return containsCycle(preReq, courseMap, visited);
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int n = s.solve(3, new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(2, 3)));
        System.out.println(n);

        n = s.solve(1, new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(2, 1)));
        System.out.println(n);

        n = s.solve(5, new ArrayList<>(Arrays.asList(1, 3, 4, 5)), new ArrayList<>(Arrays.asList(2, 1, 5, 3)));
        System.out.println(n);
    }


}

