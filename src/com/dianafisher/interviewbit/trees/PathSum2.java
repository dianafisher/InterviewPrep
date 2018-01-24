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

public class PathSum2 {

    public int hasPathSum(TreeNode a, int b) {
        if (a == null) return 0;
        boolean result = helper(a, b);
        return result ? 1 : 0;
    }

    private boolean helper(TreeNode node, int b) {

        if (node == null) return false;

        boolean result = false;
        int diff = b - node.val;

        // check that we are at a leaf node (right and left children are null)
        if (node.left == null && node.right == null) {
            if (diff == 0) {
                // found path sum = b
                return true;
            }
        }

        // otherwise, continue traversing tree until we reach a leaf
        if (node.left != null) {
            result = result || helper(node.left, diff);
        }

        if (node.right != null) {
            result = result || helper(node.right, diff);
        }

        return result;
    }

    public static void main(String[] args) {
        PathSum2 solution = new PathSum2();
        TreeNode tree = new TreeNode(5);
        tree.right = new TreeNode(8);
        tree.left = new TreeNode(4);
        tree.right.right = new TreeNode(4);
        tree.right.left = new TreeNode(13);
        tree.right.right.right = new TreeNode(1);
        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);

        System.out.println(solution.hasPathSum(tree, 22));  // expect 1

    }
}
