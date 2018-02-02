package com.dianafisher.interviewbit.trees;

/*
 *  Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the
 depth of the two subtrees of every node never differ by more than 1.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input :
          1
         / \
        2   3

Return : True or 1

Input 2 :
         3
        /
       2
      /
     1

Return : False or 0
         Because for the root node, left subtree has depth 2 and right subtree has depth 0.
         Difference = 2 > 1.
 * */

import com.dianafisher.interviewbit.data_structures.TreeNode;

public class BalancedBinaryTree {

    public int isBalanced(TreeNode a) {
        if (a == null) return 0;

        boolean balanced = checkBalanced(a);
        return balanced ? 1 : 0;
    }

    private boolean checkBalanced(TreeNode node) {

        if (node == null) return true;

        int left = getDepth(node.left);
        int right = getDepth(node.right);

        // check that heights do not differ by more than 1
        int diff = Math.abs(left - right);
        if (diff <= 1) {
            // keep checking subtrees
            if (checkBalanced(node.left) && checkBalanced(node.right)) {
                return true;
            }
        }

        return false;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;

        int left = getDepth(node.left);
        int right = getDepth(node.right);

        if (left > right) {
            return left+1;
        } else {
            return right+1;
        }
    }

    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
/*
Input :
          1
         / \
        2   3
* */
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        System.out.println(bbt.isBalanced(tree1));
/*
Input 2 :
         3
        /
       2
      /
     1
* */

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(2);
        tree2.left.left = new TreeNode(1);
        System.out.println(bbt.isBalanced(tree2));

/*
Input 3 :
         10
        /  \
       2   11
      /      \
     1       20
            /
           15
* */

        TreeNode tree3 = new TreeNode(10);
        tree3.left = new TreeNode(2);
        tree3.left.left = new TreeNode(1);
        tree3.right = new TreeNode(11);
        tree3.right.right = new TreeNode(20);
        tree3.right.right.left = new TreeNode(15);
        System.out.println(bbt.isBalanced(tree3));
    }
}
