package com.dianafisher.interviewbit.dynamic_programming.max_sum_path_in_binary_tree;

import com.dianafisher.interviewbit.data_structures.TreeNode;

/**
 * Created by dianafisher on 2/1/18.
 *
 * Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 Example :

 Given the below binary tree,

     1
    / \
   2   3

 Return 6.


 */
public class Solution {

    int max;

    public int maxPathSum(TreeNode A) {

        max = Integer.MIN_VALUE;
        traverse(A);


        return max;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = traverse(node.left);
        int right = traverse(node.right);
        // compare left with right
        // compare to current node value to current + the maximum of left and right
        int current = Math.max(node.val, node.val + Math.max(left, right));

        // calculate max
        max = Math.max(max, Math.max(current, left + node.val + right));
        return current;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(s.maxPathSum(root));

        TreeNode tree = new TreeNode(6);
        tree.left = new TreeNode(-2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(3);
        tree.left.left.left = new TreeNode(20);
        tree.left.left.right = new TreeNode(16);
        tree.left.left.left.left = new TreeNode(100);
        tree.left.right.left = new TreeNode(14);
        tree.left.right.right = new TreeNode(-10);
        tree.right.left = new TreeNode(20);
        tree.right.right = new TreeNode(-13);

        System.out.println(s.maxPathSum(tree));

        TreeNode t2 = new TreeNode(-100);
        t2.left = new TreeNode(-200);
        t2.right = new TreeNode(-300);
        t2.right.left = new TreeNode(-400);

        System.out.println(s.maxPathSum(t2));

    }

}
