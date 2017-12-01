package com.dianafisher.interviewprep.week1.interviews;

import java.util.Scanner;

/**
 * Created by dianafisher on 11/30/17.
 *
 * Alice is a teacher with a class of n children, each of whom has been assigned a numeric rating.
 * The classroom is seated in a circular arrangement, with Alice at the top of the circle.
 * She has a number of gold stars to give out based on each child's rating, but with the following conditions:

 Each child must receive at least one gold star
 Any child with a higher rating than his or her immediate neighbor should get more stars than that neighbor
 Assuming n >= 3, what is the minimum total number of stars Alice will need to give out?

 Write a program which takes as its input an int[] containing the ratings of each child, ordered by seating
 position, and returns an int value for the minimum total number of stars that Alice will need to give out.

 Hint: this problem can be solved with an algorithm that runs in O(n) time.

 For example:

 In a class of three children with ordered ratings of {1, 2, 2}, Alice will need to give out {1, 2, 1} stars
 accordingly, for a total number of 4 stars overall.

 NOTE: You should be able to implement this in pure Java using no imports, helper functions, or collections classes!


 // 1, 2, 2 becomes
 // 1, 2, 1
 */

public class GoldStars {

    public static long minimumStars(int[] arr) {

        // must give at least 1 gold star to each child
        // children with higher ratings get more stars than immediate neighbor
        int n = arr.length;
        int[] stars = new int[n];
        stars[0] = 1;

        for (int i = 1; i < n; i++) {
            stars[i] = 1;
            int current = arr[i];
            int prev = arr[i-1];
            if (current > prev) {
                // current should get more stars than prev.
                stars[i] = stars[i-1] + 1;
            }
        }

        long count = stars[n-1];
        for (int i = n-2; i > -1; i--) {
            if (arr[i] > arr[i+1]) {
                stars[i] = Math.max(stars[i], stars[i+1]+1);
            }
            count += stars[i];
        }

        for (int s : stars) {
            System.out.println(s);
        }
        return count;
    }

//    public static void main(String[] args) {
//        int[] ratings = new int[]{1,2,2};
//        System.out.println(minimumStars(ratings));
//        System.out.println("-----");
//        System.out.println(minimumStars(new int[]{2, 4, 2, 6, 1, 7, 8, 9, 2, 1}));

//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long result = minimumStars(arr);
        System.out.println(result);
        in.close();
    }
}
