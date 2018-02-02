package com.dianafisher.interviewbit.trees;

/*
*  Given a binary search tree T, where each node contains a positive integer,
*  and an integer K, you have to find whether or not there exist two different
*  nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes

Your solution should run in linear time and not take memory more than O(height of T).
Assume all values in BST are distinct.
Example :

Input 1:

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2:

T:        10
         / \
        9   20

K = 40

Return: 0
* */

import com.dianafisher.interviewbit.data_structures.TreeNode;

import java.util.HashSet;

public class TwoSumBinaryTree {

    private int k;
    private HashSet<Integer> set;
    private boolean found = false;

    public int t2Sum(TreeNode A, int B) {
        if (A == null) return 0;
        k = B;
        found = false;
        set = new HashSet<>();
        // add the root node value to the set
        set.add(A.val);

        helper(A);

        System.out.println("set = " + set);
        System.out.println("found = " + found);

        return found ? 1 : 0;
    }

    private void helper(TreeNode node) {
        if (node == null) return;

        int diff = k - node.val;
        System.out.println("diff = " + diff);
        if (set.contains(diff)) {
            found = true;
        }
        set.add(diff);
        set.add(node.val);

        helper(node.right);
        helper(node.left);
    }


    public static void main(String[] args) {
        TwoSumBinaryTree solution = new TwoSumBinaryTree();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        System.out.println(solution.t2Sum(root, 19)); // return 1
        System.out.println(solution.t2Sum(root, 40)); // return 0
    }
}
