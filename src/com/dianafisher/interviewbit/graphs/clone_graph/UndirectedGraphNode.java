package com.dianafisher.interviewbit.graphs.clone_graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dianafisher on 1/25/18.
 */
class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}


