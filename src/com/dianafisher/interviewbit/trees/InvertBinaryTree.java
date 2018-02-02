package com.dianafisher.interviewbit.trees;

/*
* Given a binary tree, invert the binary tree and return it.
Look at the example for more details.

Example :
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4

*
* */

import com.dianafisher.interviewbit.data_structures.TreeNode;

import java.util.ArrayList;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return  null;
        invertNode(root);
        return root;
    }

    private void invertNode(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.right != null) {
            invertNode(node.right);
        }
        if (node.left != null) {
            invertNode(node.left);
        }
    }

    public static void main(String[] args) {
        InvertBinaryTree ibt = new InvertBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode inverted = ibt.invertTree(root);
        InorderTraversal it = new InorderTraversal();
        ArrayList<Integer> a = it.inorderTraversal(inverted);
        for (Integer i : a) {
            System.out.println(i);
        }

    }
}
