package com.dianafisher.interviewbit.arrays;

/**
 * Created by dianafisher on 12/2/17.
 */

// Definition for an interval.
public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(").append(start).append(", ").append(end).append(")");
        return builder.toString();
    }
}
