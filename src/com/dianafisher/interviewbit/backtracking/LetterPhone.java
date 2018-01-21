package com.dianafisher.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dianafisher on 1/20/18.
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 The digit 0 maps to 0 itself.
 The digit 1 maps to 1 itself.

 Input: Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Make sure the returned strings are lexicographically sorted.

 1 -> 1
 2 -> a, b, c
 3 -> d, e, f
 4 -> g, h, i
 5 -> j, k, l
 6 -> m, n, o
 7 -> p, q, r, s
 8 -> t, u, v
 9 -> w, x, y, z


 */
public class LetterPhone {

    public ArrayList<String> letterCombinations(String A) {

        HashMap<Character, String> characterMap = new HashMap<>();
        characterMap.put('0', "0");
        characterMap.put('1', "1");
        characterMap.put('2', "abc");
        characterMap.put('3', "def");
        characterMap.put('4', "ghi");
        characterMap.put('5', "jkl");
        characterMap.put('6', "mno");
        characterMap.put('7', "pqrs");
        characterMap.put('8', "tuv");
        characterMap.put('9', "wxyz");

        ArrayList<Character> temp = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        backtrack(characterMap, result, temp, A);
        return result;
    }

    private void backtrack(HashMap<Character, String> characterMap, ArrayList<String> result, ArrayList<Character> temp, String digits) {
//        System.out.println("digits = " + digits);
        if (digits.length() == 0) {
            char[] chars = new char[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                chars[i] = temp.get(i);
            }
            result.add(String.valueOf(chars));
            return;
        }

        String digit = digits.substring(0, 1);
        String letters = characterMap.get(digit.charAt(0));

        for (int i = 0; i < letters.length(); i++) {
            temp.add(letters.charAt(i));
            backtrack(characterMap, result, temp, digits.substring(1));
            temp.remove(temp.size() - 1);
        }

    }


    public static void main(String[] args) {
        LetterPhone p = new LetterPhone();
        System.out.println(p.letterCombinations("23"));
        System.out.println(p.letterCombinations("0"));
    }

}
