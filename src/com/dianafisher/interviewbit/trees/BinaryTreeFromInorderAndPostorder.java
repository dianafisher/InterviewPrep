package com.dianafisher.interviewbit.trees;

/*
* Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree.
Example :

Input :
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

Return :
            1
           / \
          2   3

Given binary tree

             1
           /   \
          2     3
         / \   / \
        4   5 6   7
       /     \
      11      9
     /  \      \
    12   13    10

Inorder:    12, 11, 13, 4, 2, 5, 9, 10, 1, 6, 3, 7
Post Order: 12, 13, 11, 4, 10, 9, 5, 2, 6, 7, 3, 1
*
*
*   Inorder : left, parent, right
*   Post order: left, right, parent
*
*  Last element in Post Order array is the root of the tree.
* */

import com.dianafisher.interviewbit.data_structures.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeFromInorderAndPostorder {

    private ArrayList<Integer> postOrder;
    private ArrayList<Integer> inOrder;
    private int postIndex;

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {

        if (inorder == null || postorder == null) return null;
        this.postOrder = postorder;
        this.inOrder = inorder;
        int N = postOrder.size();
        this.postIndex = N-1;

        return helper(0, N-1);
    }

    private TreeNode helper(int start, int end) {
        if (start > end) return null;

        TreeNode node = new TreeNode(postOrder.get(postIndex));
        postIndex--;
        if (start == end) {
            return node;
        }

        int inIndex = inOrder.indexOf(node.val);
        node.right = helper(inIndex+1, end);
        node.left = helper(start, inIndex-1);
        return node;
    }


    public static void main(String[] args) {
        ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(2, 1, 3));
        ArrayList<Integer> postorder = new ArrayList<>(Arrays.asList(2, 3, 1));

        BinaryTreeFromInorderAndPostorder solution = new BinaryTreeFromInorderAndPostorder();
        TreeNode tree = solution.buildTree(inorder, postorder);
        solution.printTreeInorder(tree);

        System.out.println("----");
        System.out.println();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(11);
        root.left.left.left.right = new TreeNode(13);
        root.left.left.left.left = new TreeNode(12);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(9);
        root.left.right.right.right = new TreeNode(10);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);

        solution.printTreeInorder(root);
        System.out.println();
        solution.printTreePostorder(root);

        System.out.println("----");
        System.out.println();

        inorder = new ArrayList<>(Arrays.asList(12, 11, 13, 4, 2, 5, 9, 10, 1, 6, 3, 7));
        postorder = new ArrayList<>(Arrays.asList(12, 13, 11, 4, 10, 9, 5, 2, 6, 7, 3, 1));
        tree = solution.buildTree(inorder, postorder);
        solution.printTreeInorder(tree);
    }

    private void printTreeInorder(TreeNode node) {
        if (node == null) return;

        printTreeInorder(node.left);
        System.out.println(node.val );
        printTreeInorder(node.right);

    }

    private void printTreePostorder(TreeNode node) {
        if (node == null) return;

        printTreePostorder(node.left);
        printTreePostorder(node.right);

        System.out.println(node.val);
    }

}
