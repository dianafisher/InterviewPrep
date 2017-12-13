package com.dianafisher.interviewbit.trees;

/*
* Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

Using recursion is not allowed.

* */

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

    /*
     * Preorder traversal:  Root, Left, Right
     * */
    public ArrayList<Integer> preorderTraversal(TreeNode a) {

        ArrayList<Integer> result = new ArrayList<>();

        if (a == null) return result;

        Stack<TreeNode> stack = new Stack();
        TreeNode current = a;

        // Push the root node onto the stack
        stack.push(current);

        while (!stack.isEmpty()) {
            // pop a node off of the stack
            TreeNode node = stack.pop();
            result.add(node.val);

            // push the right and left nodes onto the stack
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    public void preorderTraversalRecursive(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
    }

    public static void main(String[] args) {
        PreorderTraversal pt = new PreorderTraversal();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        ArrayList<Integer> result = pt.preorderTraversal(root);   // 1, 2, 3
        for (Integer i : result) {
            System.out.println(i);
        }

        root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);

        result = pt.preorderTraversal(root);  // 1, 2, 4, 5, 3
        for (Integer i : result) {
            System.out.println(i);
        }

        System.out.println("------");
        pt.preorderTraversalRecursive(root);
    }
}
