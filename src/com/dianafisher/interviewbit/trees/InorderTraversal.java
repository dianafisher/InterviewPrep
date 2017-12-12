package com.dianafisher.interviewbit.trees;

/*
* Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.

*
* */


import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

    /*
    * Inorder traversal:  Left, Root, Right
    * */
    public ArrayList<Integer> inorderTraversal(TreeNode a) {

        ArrayList<Integer> result = new ArrayList<>();
        if (a == null) return result;

        Stack<TreeNode> stack = new Stack();
        TreeNode current = a;


        while (true) {
            // First, go left
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                TreeNode t = stack.pop();
                result.add(t.val);
                current = t.right;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        InorderTraversal it = new InorderTraversal();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        ArrayList<Integer> result = it.inorderTraversal(root);   // 1, 3, 2
        for (Integer i : result) {
            System.out.println(i);
        }

        root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);

        result = it.inorderTraversal(root);  // 4, 2, 5, 1, 3
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
