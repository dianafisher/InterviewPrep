package com.dianafisher.interviewbit.arrays;

/**
 * Created by dianafisher on 12/1/17.
 *
 * Given a collection of intervals, merge all overlapping intervals.

 For example:

 Given [1,3],[2,6],[8,10],[15,18],

 return [1,6],[8,10],[15,18].

 Make sure the returned intervals are sorted.

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        int n = intervals.size();
        if (intervals.size() == 1) return intervals;

        // First, sort the intervals by start
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        ArrayList<Interval> result = new ArrayList<Interval>();

        Interval current = intervals.get(0);

        for (int i = 0; i < n; i++) {
            Interval next = intervals.get(i);

//            System.out.println("current: " + current);
//            System.out.println("next = " + next);

            if (next.start > current.end) {
                result.add(current);
                current = next;
            } else {
                // merge the intervals
                Interval m = new Interval(current.start, Math.max(current.end, next.end));
                current = m;
            }
            System.out.println();
        }
        // add the last interval
        result.add(current);


        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> a = new ArrayList<Interval>();
        a.add(new Interval(1,3));
        a.add(new Interval(2,6));
        a.add(new Interval(8,10));
        a.add(new Interval(15,18));

        ArrayList<Interval> merged = merge(a);
        for (Interval i : merged) {
            System.out.println(i);
        }

        a = new ArrayList<Interval>();
        a.add(new Interval(1,10));
        a.add(new Interval(2,9));
        a.add(new Interval(3,8));
        a.add(new Interval(4,7));
        a.add(new Interval(5,6));
        a.add(new Interval(6,6));

        merged = merge(a);
        for (Interval i : merged) {
            System.out.println(i);
        }

        a = new ArrayList<Interval>();
        a.add(new Interval(1,3));
        a.add(new Interval(4,8));
        a.add(new Interval(6,10));

        merged = merge(a);
        for (Interval i : merged) {
            System.out.println(i);
        }



    }
}
