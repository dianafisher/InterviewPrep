package com.dianafisher.interviewbit.trees;

/*
* Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input :

   1       1
  / \     / \
 2   3   2   3

Output :
  1 or True
*
* */

import java.util.Stack;

public class IdenticalBinaryTrees {

    public int isSameTree(TreeNode a, TreeNode b) {

        // both empty
        if (a == null && b == null) return 1;

        // both non-empty
        if (a != null && b != null) {
            int result = (a.val == b.val) ? 1 : 0;
            int left = isSameTree(a.left, b.left);
            int right = isSameTree(a.right, b.right);

            if (result == 1 && left == 1 && right == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(3);
        a.left = new TreeNode(2);
        a.left.right = new TreeNode(5);
        a.left.left = new TreeNode(4);

        TreeNode b = new TreeNode(1);
        b.right = new TreeNode(3);
        b.left = new TreeNode(2);
        b.left.right = new TreeNode(6);
        b.left.left = new TreeNode(4);

        IdenticalBinaryTrees ibt = new IdenticalBinaryTrees();
        System.out.println(ibt.isSameTree(a, b));
    }
}
