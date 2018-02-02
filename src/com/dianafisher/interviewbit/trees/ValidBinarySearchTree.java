package com.dianafisher.interviewbit.trees;

/*
* Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.

* */

import com.dianafisher.interviewbit.data_structures.TreeNode;

public class ValidBinarySearchTree {

    private int isSubtreeLesser(TreeNode root, int value) {
        if (root == null) return 1;

        if (root.val <= value
                && isSubtreeLesser(root.left, value) == 1
                && isSubtreeLesser(root.right, value) == 1) {
            return 1;
        }
        return 0;
    }

    private int isSubtreeGreater(TreeNode root, int value) {
        if (root == null) return 1;

        if (root.val > value
                && isSubtreeGreater(root.left, value) == 1
                && isSubtreeGreater(root.right, value) == 1) {
            return 1;
        }
        return 0;
    }

    public int isValidBST(TreeNode a) {

        if (a == null) return 1;
        if (isSubtreeLesser(a.left, a.val) == 1
                && isSubtreeGreater(a.right, a.val)  == 1
                && isValidBST(a.left) == 1
                && isValidBST(a.right) == 1) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        ValidBinarySearchTree vbst = new ValidBinarySearchTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(vbst.isValidBST(root));

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(vbst.isValidBST(root));
    }
}
