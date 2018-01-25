package com.dianafisher.interviewbit.graphs.clone_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by dianafisher on 1/25/18.
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 */
public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);

        // create a copy of the node and add it to the map
        nodeMap.put(node, new UndirectedGraphNode(node.label));

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            UndirectedGraphNode currentCopy = nodeMap.get(current);
            for (UndirectedGraphNode neighbor : current.neighbors) {

                UndirectedGraphNode neighborCopy = nodeMap.get(neighbor);
                if (neighborCopy == null) {
                    queue.offer(neighbor);
                    neighborCopy = new UndirectedGraphNode(neighbor.label);
                    nodeMap.put(neighbor, neighborCopy);

                }
                currentCopy.neighbors.add(neighborCopy);
            }
        }

        return nodeMap.get(node);
    }
}
