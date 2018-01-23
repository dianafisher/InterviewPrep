package com.dianafisher.interviewbit.graphs;

/**
 * Created by dianafisher on 1/22/18.
 *
 * Given a binary tree, return the level order traversal of its nodes’ values.
 * (ie, from left to right, level by level).

 Example :
 Given binary tree

      3
    /  \
   9   20
  /     \
 15     7

 return its level order traversal as:

 [
    [3],
    [9,20],
    [15,7]
 ]

 Also think about a version of the question where you are asked to do a level order traversal
 of the tree when depth of the tree is much greater than number of nodes on a level.
 */


import com.dianafisher.interviewbit.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (A == null) return result;

        int current = 1;
        int next = 0;
        queue.offer(A);

        ArrayList<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            level.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (current == 0) {
                current = next;
                next = 0;
                result.add(new ArrayList<>(level));
                level.clear();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(15);

        LevelOrder s = new LevelOrder();
        System.out.println(s.levelOrder(root));
    }
}

