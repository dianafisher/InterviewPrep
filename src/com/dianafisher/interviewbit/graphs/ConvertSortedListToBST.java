package com.dianafisher.interviewbit.graphs;

import com.dianafisher.interviewbit.linkedlists.ListNode;
import com.dianafisher.interviewbit.trees.InorderTraversal;
import com.dianafisher.interviewbit.trees.TreeNode;

/**
 * Created by dianafisher on 1/22/18.
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which
 the depth of the two subtrees of every node never differ by more than 1.

 Example :


 Given A : 1 -> 2 -> 3
 A height balanced BST  :

     2
   /   \
  1     3


 */
public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode a) {
        if (a == null) return null;

        return buildTree(a, null);
    }


    private TreeNode buildTree(ListNode startNode, ListNode endNode) {
        if (startNode == endNode) return null;

        ListNode fast = startNode;
        ListNode slow = startNode;

        while (fast != endNode && fast.next != endNode) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = buildTree(startNode, slow);
        node.right = buildTree(slow.next, endNode);

        return node;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(4);
        list.next.next = new ListNode(8);

        ConvertSortedListToBST c = new ConvertSortedListToBST();
        TreeNode tree = c.sortedListToBST(list);

        InorderTraversal it = new InorderTraversal();
        System.out.println(it.inorderTraversal(tree));
    }
}
