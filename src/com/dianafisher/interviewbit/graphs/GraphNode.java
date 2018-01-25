package com.dianafisher.interviewbit.graphs;

import java.util.ArrayList;

/**
 * Created by dianafisher on 1/24/18.
 */
public class GraphNode {

    public int val;
    public ArrayList<GraphNode> children;
    public boolean visited;

    public GraphNode(int x) {
        this.val = x;
        this.children = new ArrayList<>();
        this.visited = false;
    }

    public void addChild(GraphNode node) {
        this.children.add(node);
    }

    @Override
    public String toString() {
        return "val: " + val + ", visited: " + visited + " num children: " + children.size();
    }
}
