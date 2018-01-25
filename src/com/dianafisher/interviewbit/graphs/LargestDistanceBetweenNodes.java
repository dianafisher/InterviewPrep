package com.dianafisher.interviewbit.graphs;

import java.util.*;

/**
 * Created by dianafisher on 1/24/18.
 *
 * Find largest distance

 Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.
 The goal of the problem is to find largest distance between two nodes in a tree.
 Distance between two nodes is a number of edges on a path between the nodes
 (there will be a unique path between any pair of nodes since it is a tree).
 The nodes will be numbered 0 through N - 1.

 The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N).
 Exactly one of the i’s will have P[i] equal to -1, it will be root node.

 Example:

 If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this:

    0
 /  |  \
 1   2   3
         \
         4
 */

public class LargestDistanceBetweenNodes {


    public int solve(ArrayList<Integer> A) {

        if (A == null || A.size() == 0) return 0;

        //  Edge between P[i] and i  where (0 <= i <= N)

        Map<Integer, List<Integer>> graph = new HashMap<>();

        int N = A.size();

        for (int i = 0; i < N; i++) {
            int node = A.get(i);

            if (node != -1) {
                if (!graph.containsKey(node))
                    graph.put(node, new ArrayList<>());

                graph.get(node).add(i);
            }
        }

        Map<Integer, Map<Integer, Integer>> D = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            // leaf nodes
            if (!graph.containsKey(i)) {
                int parent = A.get(i);
                int child = i;
                int depth = 0;
                while (parent != -1) {
                    depth++;
                    if (!D.containsKey(parent))
                        D.put(parent, new HashMap<>());
                    Integer tmp = D.get(parent).get(child);
                    D.get(parent).put(child, tmp != null ? Math.max(tmp, depth) : depth);
                    child = parent;
                    parent = A.get(parent);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            Map<Integer, Integer> nodes = D.get(i);
            if (nodes != null) {
                int d1 = 0;
                int d2 = 0;
                for (int d : nodes.values()) {
                    if (d > d1) {
                        d2 = d1;
                        d1 = d;
                    } else if (d > d2) {
                        d2 = d;
                    }
                }
                max = Math.max(max, d1 + d2);
            }
        }
        return max;
    }



    public int solve2(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) return 0;

        HashMap<Integer, GraphNode> nodeMap = new HashMap<>();

        //  Edge between P[i] and i  where (0 <= i <= N)

        int N = A.size();
        GraphNode root = null;
        for (int i = 0; i < N; i++) {
            int pi = A.get(i);
            System.out.println("edge between " + pi + " and " + i);
            if (pi == -1 && root == null) {
                root = new GraphNode(i);
                nodeMap.put(i, root);
            } else {
                // edge between pi and i
                GraphNode node = new GraphNode(i);
                nodeMap.put(i, node);
                if (nodeMap.containsKey(pi)) {
                    GraphNode parent = nodeMap.get(pi);
                    parent.addChild(node);
                } else {
                    System.err.println("Cannot find node for " + pi);
                }
            }
        }


        for (int i : nodeMap.keySet()) {
            GraphNode node = nodeMap.get(i);
            dfsDistance(node, 0);
        }


        return 0;
    }

    private void dfsDistance(GraphNode node, int length) {
        node.visited = true;
        int currentLength = 0;

        for (GraphNode child : node.children) {
            if (!child.visited) {
                currentLength = length + 1;
                dfsDistance(child, currentLength);
            }
        }
        System.out.println("currentLength = " + currentLength);
    }

    private void dfs(GraphNode root) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(root);
        root.visited = true;
        System.out.println("root = " + root);

        while (!stack.isEmpty()) {
            GraphNode n = stack.peek();
            GraphNode child = getUnvisitedChildNode(n);
            if (child != null) {
                child.visited = true;
                System.out.println("child = " + child);
                stack.push(child);
            } else {
                stack.pop();
            }
        }
    }

    private GraphNode getUnvisitedChildNode(GraphNode node) {
        for (GraphNode child : node.children) {
            if (!child.visited) {
                return child;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LargestDistanceBetweenNodes s = new LargestDistanceBetweenNodes();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-1, 0, 0, 0, 3));
        System.out.println(s.solve(a));
    }
}
