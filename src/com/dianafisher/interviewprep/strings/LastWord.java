package com.dianafisher.interviewprep.strings;

/**
 * Created by dianafisher on 11/23/17.
 */
public class LastWord {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        int count = 0;

        for (int i = A.length() - 1; i > -1; i--) {
            if (A.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
