package com.company;

import java.util.*;

public class Solver implements ConundrumSolver {
    @Override
    public int[] resolve(int[] initialState) {
        Graph start = new Graph(initialState);
        Graph end = new Graph(new int[] {1,2,3,4,0,5,6,7});
        Map<Graph, Graph> stateTrack = new HashMap<Graph, Graph>();
        stateTrack.put(start, null);
        Queue<Graph> queue = new ArrayDeque<Graph>();
        queue.offer(start);
        while (queue.size() != 0) {
            Graph state = queue.poll();
            //state.ShowCurrentState(state.GetCurrentState());
            //System.out.println(state.hashCode());
            if (state.IsSolved()) break;
            ArrayList<Graph> nextStates = state.GetNextStates();
            for (Graph nextState : nextStates) {
                if (!stateTrack.containsKey(nextState)){
                    stateTrack.put(nextState,state);
                    queue.offer(nextState);
                }
            }
        }
        //ArrayList result = new ArrayList();
        while (end != null)
        {
            end.ShowCurrentState(end.GetCurrentState());
            end = stateTrack.get(end);
        }

        return new int[0];
    }
}


