package com.dianafisher.interviewbit.trees.unique_binary_search_trees;

import com.dianafisher.interviewbit.graphs.LevelOrder;
import com.dianafisher.interviewbit.data_structures.TreeNode;

import java.util.ArrayList;

/**
 * Created by dianafisher on 1/25/18.
 *
 * Given A, generate all structurally unique BST’s (binary search trees) that store values 1...A.
 *
 *
 */
public class Solution {

    public ArrayList<TreeNode> generateTrees(int a) {

        ArrayList<TreeNode> result = new ArrayList<>();
        if (a < 1) return result;

        result = buildTrees(1, a);
        return result;
    }

    private ArrayList<TreeNode> buildTrees(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
//        System.out.println("start = " + start);
        for (int i = start; i <= end; i++) {

            ArrayList<TreeNode> leftTree = buildTrees(start, i-1);
            ArrayList<TreeNode> rightTree = buildTrees(i+1, end);

            for (TreeNode left: leftTree ) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
//        System.out.println("result = " + result);
        return result;
    }

    private void insert(TreeNode node, int key) {

        if (key < node.val) {
            if (node.left == null) {
                TreeNode leftNode = new TreeNode(key);
                node.left = leftNode;
            } else {
                insert(node.left, key);
            }
        } else {
            if (node.right == null) {
                TreeNode rightNode = new TreeNode(key);
                node.right = rightNode;
            } else {
                insert(node.right, key);
            }
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<TreeNode> trees = s.generateTrees(3);
        LevelOrder t = new LevelOrder();

        for (TreeNode tree : trees) {

            System.out.println(t.levelOrder(tree));
            System.out.println("------");
        }
    }
}