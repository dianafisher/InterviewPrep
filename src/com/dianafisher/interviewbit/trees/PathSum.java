package com.dianafisher.interviewbit.trees;

/*
* Given a binary tree and a sum, determine if the tree has a root-to-leaf
* path such that adding up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
* */

import com.dianafisher.interviewbit.data_structures.TreeNode;

public class PathSum {

    public int hasPathSum(TreeNode a, int b) {

        int result = helperMethod(a, b) ? 1 : 0;
        return result;
    }

    public boolean helperMethod(TreeNode node, int sum) {
        if (node == null) return false;

        boolean result = false;

        int diff = sum - node.val;
        if (diff == 0 && node.right == null && node.left == null) {
            return true;
        }
        if (node.left != null) {
            result = result || helperMethod(node.left, diff);
        }
        if (node.right != null) {
            result = result || helperMethod(node.right, diff);
        }
        return result;
    }

    public static void main(String[] args) {
        PathSum ps = new PathSum();

        TreeNode tree = new TreeNode(5);
        tree.right = new TreeNode(8);
        tree.left = new TreeNode(4);
        tree.right.right = new TreeNode(4);
        tree.right.left = new TreeNode(13);
        tree.right.right.right = new TreeNode(1);
        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);

        System.out.println(ps.hasPathSum(tree, 22));  // expect 1
    }
}
