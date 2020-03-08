package com.company;

import java.util.*;

public class Solver implements ConundrumSolver {
    @Override
    public int[] resolve(int[] initialState) {
        Graph model = new Graph(initialState);
        Map<Graph, Graph> stateTrack = new HashMap<Graph, Graph>();
        stateTrack.put(model, null);
        Queue<Graph> queue = new ArrayDeque<Graph>();
        queue.offer(model);
        while (queue.size() != 0) {
            Graph state = queue.poll();
            state.ShowCurrentState(state.GetCurrentState());
            System.out.println(state.hashCode());
            if (state.IsSolved()) break;
            ArrayList<Graph> nextStates = state.GetNextStates();
            for (Graph nextState : nextStates) {
                if (!stateTrack.containsKey(nextState)){
                    stateTrack.put(nextState,state);
                    queue.offer(nextState);
                }
            }
        }

        return new int[0];
    }
}


