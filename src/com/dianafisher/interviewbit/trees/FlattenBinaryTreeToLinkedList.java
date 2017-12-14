package com.dianafisher.interviewbit.trees;

/*
* Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.
* */

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public TreeNode flatten(TreeNode a) {
        if (a == null) return null;

        Stack<TreeNode> stack = new Stack();

        TreeNode current = a;

        while (current != null || !stack.isEmpty()) {
            if (current.right != null) {
                // put right node on the stack
                stack.push(current.right);
            }
            if (current.left != null) {
                // move left node to right
                current.right = current.left;
                current.left = null;
            } else if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                current.right = temp;
            }
            current = current.right;
        }

        return a;
    }

    public TreeNode flatten_editorial(TreeNode a) {
        if(a==null) {
            return null;
        }

        TreeNode node = a;
        while(node!=null)
        {
            if(node.left!=null)
            {
                TreeNode rightmost = node.left;
                while(rightmost.right!=null)
                {
                    rightmost=rightmost.right;


                }
                rightmost.right=node.right;
                node.right=node.left;
                node.left=null;
            }
            node=node.right;
        }
        return a;

    }


    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();

        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right.right = new TreeNode(6);
        node.left.right = new TreeNode(4);
        node.left.left = new TreeNode(3);

        TreeNode flat = solution.flatten(node);
        TreeNode current = flat;
        while (current != null) {
            System.out.println(current.val);
            current = current.right;
        }
    }
}
