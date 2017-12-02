package com.dianafisher.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by dianafisher on 12/1/17.
 *
 * Given a non-negative number represented as an array of digits,

 add 1 to the number ( increment the number represented by the digits ).

 The digits are stored such that the most significant digit is at the head of the list.

 Example:

 If the vector has [1, 2, 3]

 the returned vector should be [1, 2, 4]

 as 123 + 1 = 124.

 Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 A : For the purpose of this question, YES

 Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

 */
public class AddOneToNumber {

    /*
    * [1,2,3] returns [1,2,4] since 123 + 1 = 124
    * [0,8,8,1,7,2,1,3,5,9]  returns [8,8,1,7,2,1,6,0] since 881721359 + 1 = 88172160
    * [1,9,9,9,9,9] returns [2,0,0,0,0,0] since 199999 + 1 = 200000
    * [9,9,9,9,9,9] returns [1,0,0,0,0,0,0] since 999999 + 1 = 1000000
    *
    * Start from end of the input array and work backwards.
    * Add one to the last digit in the array.
    * If the result is greater than nine, add a zero to the output array and carry the one to the next digit.
    *
    * // 9+1 = 10 -> add a zero to output array, carry 1 to next iteration
    *
    * */

    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a == null) return result;

        Stack<Integer> output = new Stack<Integer>();
        int n = a.size();
        int carry = 0;
        for (int i = n-1; i > -1; i--) {
            // are we at the end of the array?
            int val = a.get(i);
            if (i == n-1) {
                // add 1 to the value
                val += 1;
            } else {
                val += carry;
                carry = 0;
            }
            if (val > 9) {
                output.push(0);
                carry = 1;
            } else {
                output.push(val);
            }
        }
        // check for carry at the end...
        if (carry != 0) {
            output.push(carry);
        }

//        System.out.println(output);

        // now create the resulting array list from the stack
        while (!output.isEmpty()) {
            result.add(output.pop());
        }

        // remove any leading zeroes
        while (result.get(0) == 0) {
            result.remove(0);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        System.out.println(plusOne(a));      // expect [1,2,4]

        a = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3));
        System.out.println(plusOne(a));      // expect [1,2,4]

        a = new ArrayList<Integer>(Arrays.asList(0, 8, 8, 1, 7, 2, 1, 3, 5, 9));
        System.out.println(plusOne(a));      // expect [8,8,1,7,2,1,3,6,0]

        a = new ArrayList<Integer>(Arrays.asList(9,9,9,9,9,9));
        System.out.println(plusOne(a));      // expect [1,0,0,0,0,0,0]

        a = new ArrayList<Integer>(Arrays.asList(0, 0, 4, 4, 6, 0, 9, 6, 5, 1));
        System.out.println(plusOne(a));      // expect [4 4 6 0 9 6 5 2 ]
    }
}
