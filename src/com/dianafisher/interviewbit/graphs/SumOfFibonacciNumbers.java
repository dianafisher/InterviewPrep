package com.dianafisher.interviewbit.graphs;

import java.util.ArrayList;

/**
 * Created by dianafisher on 1/22/18.
 *
 * How many minimum numbers from fibonacci series are required
 * such that sum of numbers should be equal to a given Number N?

 Note : repetition of number is allowed.

 Example:

 N = 4
 Fibonacci numbers : 1 1 2 3 5 .... so on
 here 2 + 2 = 4
 so minimum numbers will be 2

 */
public class SumOfFibonacciNumbers {

    public int fibsum(int A) {
        if (A <= 2) return 1;

        int a = 1;
        int b = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);

        // generate the fibonacci numbers up to A
        int total = 0;
        while (total <= A) {
            total =  a + b;
            numbers.add(total);

            a = b;
            b = total;
        }

//        System.out.println("numbers = " + numbers);

        int count = 0;
        int n = A;
        int index = numbers.size()-1;
        while (n > 0) {
            int num = numbers.get(index);
            if (n >= num) {
                count += (n/num);
                n %= num;
            }
            index--;
        }
        return count;
    }

    public static void main(String[] args) {
        SumOfFibonacciNumbers s = new SumOfFibonacciNumbers();
        System.out.println(s.fibsum(4));
    }
}
