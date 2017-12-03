package com.dianafisher.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dianafisher on 12/2/17.
 */
public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        if (newInterval.start > newInterval.end) {
            // swap start and end
            int temp = newInterval.end;
            newInterval.end = newInterval.start;
            newInterval.start = temp;
        }

//        System.out.println("Insert " + newInterval + " into: ");
//
//        for (Interval i : intervals) {
//            System.out.println(i);
//        }


        ArrayList<Interval> list = new ArrayList<Interval>();

        // Add all intervals that come before the newInterval
        int idx = 0;
        while (idx < intervals.size()) {
            Interval i = intervals.get(idx);
            if (i.start <= newInterval.start) {
                list.add(i);
            } else {
                break;
            }
            idx++;
        }

        // Now add newInterval
        list.add(newInterval);

        // Now add the rest of the intervals.
        for (int j = idx; j < intervals.size(); j++) {
            list.add(intervals.get(j));
        }

//        System.out.println();
//        System.out.println("--- LIST ---");

//        for (Interval i : list) {
//            System.out.println(i);
//        }

        // We now have all intervals sorted by start time.  Now we can merge them.
        Stack<Interval> stack = new Stack<Interval>();
        stack.push(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            Interval top = stack.peek();

            Interval current = list.get(i);
            // if current interval does not overlap with stack top, then push it onto the stack
            if (top.end < current.start) {
                stack.push(current);
            }
            // otherwise, update the end time of top
            else if (top.end < current.end) {
                top.end = current.end;
                stack.pop();
                stack.push(top);
            }
        }

        // System.out.println();

        for (Interval i : stack) {
//            System.out.println(i);
            result.add(i);
        }
        return result;

    }
}
