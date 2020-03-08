package com.company;

import java.util.*;

public class Solver implements ConundrumSolver {
    @Override
    public int[] resolve(int[] initialState) {
        Graph start = new Graph(initialState);
        Graph end = new Graph(new int[]{1, 2, 3, 4, 0, 5, 6, 7});
        Map<Graph, Graph> stateTrack = new HashMap<>();
        stateTrack.put(start, null);
        Queue<Graph> queue = new ArrayDeque<>();
        queue.offer(start);
        while (queue.size() != 0) {
            Graph state = queue.poll();
            if (state.isSolved()) break;
            ArrayList<Graph> nextStates = state.getNextStates();
            for (Graph nextState : nextStates) {
                if (!stateTrack.containsKey(nextState)) {
                    stateTrack.put(nextState, state);
                    queue.offer(nextState);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (end != null) {
            end.showCurrentState(end.getCurrentState());
            if (!(stateTrack.get(end) == null))
                result.add(end.getChangedValue(stateTrack.get(end)));
            end = stateTrack.get(end);
        }
        Collections.reverse(result);
        System.out.println("Solve:");
        for (int i : result) {
            System.out.print(i);
        }
        return getArrayFromList(result);
    }

    public static int[] getArrayFromList(ArrayList<Integer> arrayList) {
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}


