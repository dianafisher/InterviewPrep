package com.dianafisher.interviewbit.stacks_and_queues;

/*
* Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.

/a/./b/../../c/

/a/ -> directory a
./b -> directory b
../ -> move up a directory  (pop stack)
../ -> move up a directory
/c/

* */

import java.util.Stack;

public class SimplifyDirectoryPath {

    public String simplifyPath(String a) {
        String[] dirs = a.split("/");

        Stack<String> stack = new Stack<>();
        for (String s : dirs) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.equals(".")) {

            }
            else if (s.length() > 0) {
                stack.push(s);
            }
        }

        StringBuilder path = new StringBuilder();
        path.append("/");

        for (String s : stack) {
            path.append(s).append("/");
        }

        // remove the trailing '/' character
        if (path.length() > 1) {
            path.deleteCharAt(path.length()-1);
        }


        return path.toString();
    }

    public static void main(String[] args) {
        SimplifyDirectoryPath sdp = new SimplifyDirectoryPath();
        System.out.println(sdp.simplifyPath("/a/./b/../../c/"));  // returns "/c"
        System.out.println(sdp.simplifyPath("/home/"));  // returns "/home"
    }
}
