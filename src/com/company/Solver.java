package com.company;

import java.util.*;

public class Solver implements ConundrumSolver {
    @Override
    public int[] resolve(int[] initialState) {
        Graph model = new Graph(initialState);
        Map<Graph, Graph> stateTrack = new HashMap<Graph, Graph>();
        stateTrack.put(model, null);
        Queue<Graph> queue = new PriorityQueue<Graph>();
        queue.add(model);
        while (queue.size() != 0) {
            Graph state = queue.peek();
            ArrayList<Graph> nextStates = state.GetNextStates();
        }

        return new int[0];
    }
}


