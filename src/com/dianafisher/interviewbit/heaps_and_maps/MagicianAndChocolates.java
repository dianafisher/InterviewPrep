package com.dianafisher.interviewbit.heaps_and_maps;

/*
*
* Given N bags, each bag contains Ai chocolates. There is a kid and a magician.
* In one unit of time, kid chooses a random bag i, eats Ai chocolates,
* then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14

At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7
*
* */

import java.util.*;

public class MagicianAndChocolates {

    public long nchoc(int A, ArrayList<Integer> B) {

        int N = B.size();
        if (N == 0) return 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(N, Collections.reverseOrder()); // max first

        for (int i = 0; i < N; i++) {
            queue.add(B.get(i));
        }

        long result = 0;
        while (A > 0) {
            System.out.println(queue);
            int top = queue.poll();

//            System.out.println("top = " + top);
            result += top;

            int next = top/2;
            queue.add(next);
            A--;
        }


//        System.out.println("result = " + result);

        return result % (1000000000 + 7);
    }

    public static void main(String[] args) {
        MagicianAndChocolates mac = new MagicianAndChocolates();

        ArrayList<Integer> bags = new ArrayList<>(Arrays.asList(6, 5));
        System.out.println(mac.nchoc(3, bags));  // 14

        bags = new ArrayList<>(Arrays.asList(69, 61));
        System.out.println(mac.nchoc(34, bags));  // 252


        bags = new ArrayList<>(Arrays.asList(2147483647, 2000000014, 2147483647));
        System.out.println(mac.nchoc(10, bags));  // 284628164

    }
}
