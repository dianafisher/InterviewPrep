package com.dianafisher.interviewbit.trees;

import com.dianafisher.interviewbit.data_structures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dianafisher on 1/24/18.
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values.
 * (ie, from left to right, then right to left for the next level and alternate between).

 Example :
 Given binary tree

    3     (left to right)
   / \
  9  20   (right to left)
    /  \
   15   7  (left to right)
 return

 [
 [3],
 [20, 9],
 [15, 7]
 ]
 */
public class ZigZagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (A == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        int current = 1;
        int prev = 0;

        boolean leftToRight = true;
        ArrayList<Integer> level = new ArrayList<>();
        while(!queue.isEmpty()) {
            current--;
            TreeNode node = queue.poll();
            level.add(node.val);


            if (node.left != null) {
                queue.offer(node.left);
                prev++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                prev++;
            }

//            System.out.println("leftToRight = " + leftToRight);

            if (current == 0) {

                current = prev;
                prev = 0;
//                System.out.println("level = " + level);

                if (!leftToRight) {
                    Collections.reverse(level);
                }

                result.add(new ArrayList<>(level));

                level.clear();
                leftToRight = !leftToRight;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversal zz = new ZigZagLevelOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zz.zigzagLevelOrder(root));
    }
}
