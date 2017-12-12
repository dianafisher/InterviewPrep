package com.dianafisher.interviewbit.trees;

/*
* Given a binary tree, find its maximum depth.

The maximum depth of a binary tree is the number of nodes along
the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node.
Example :

         1
        /
       2

max depth = 2.
* */

import java.util.ArrayList;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode a) {

        if (a == null) return 0;

        int right = maxDepth(a.right);
        int left = maxDepth(a.left);

        int max = Math.max(right, left);
        return max + 1;

    }


    public static void main(String[] args) {
        MaxDepthOfBinaryTree solution = new MaxDepthOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(solution.maxDepth(root));   // 2

        root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);

        System.out.println(solution.maxDepth(root));
    }
}
