package com.company;

import java.util.ArrayList;

public class Graph {
    private final ArrayList<Node> nodes = new ArrayList<>();

    public Graph(int[] initialState) {
        if (initialState.length < 8)
            throw new IllegalArgumentException("Invalid initial state.");
        int[] temp = new int[initialState.length - 1];
        for (int i = 0; i < initialState.length; i++) {
            if (i < 4)
                temp[i] = initialState[i];
            else if (i > 4)
                temp[i - 1] = initialState[i];
        }
        for (int i = 0; i < initialState.length; i++) {
            if (i == 0)
                nodes.add(new Node(initialState[4], i));
            else
                nodes.add(new Node(temp[i - 1], i));
        }
        nodes.get(1).connectWith(nodes.get(2));
        nodes.get(1).connectWith(nodes.get(3));
        nodes.get(2).connectWith(nodes.get(3));
        nodes.get(2).connectWith(nodes.get(4));
        nodes.get(3).connectWith(nodes.get(5));
        nodes.get(4).connectWith(nodes.get(0));
        nodes.get(4).connectWith(nodes.get(6));
        nodes.get(5).connectWith(nodes.get(0));
        nodes.get(5).connectWith(nodes.get(7));
        nodes.get(6).connectWith(nodes.get(7));
    }

    public Node getNodeById(int id) {
        return nodes.get(id);
    }

    public int[] getCurrentState() {
        int[] result = new int[nodes.size()];
        for (int i = 0; i < result.length; i++) {
            if (i == 0)
                result[4] = nodes.get(i).getValue();
            else if (i < 5)
                result[i - 1] = nodes.get(i).getValue();
            else
                result[i] = nodes.get(i).getValue();
        }
        return result;
    }

    public ArrayList<Graph> getNextStates() {
        ArrayList<Graph> result = new ArrayList<>();
        for (Node emptyNode : nodes) {
            if (emptyNode.getValue() == 0) {
                for (Node currentNode : emptyNode.getConnectedNodes()) {
                    Graph newState = new Graph(this.getCurrentState());
                    newState.getNodeById(emptyNode.getId()).changeValueWith(newState.getNodeById(currentNode.getId()));
                    result.add(newState);
                }
            }
        }
        return result;
    }

    public boolean isSolved() {
        for (Node n : nodes)
            if (n.getValue() != n.getId()) return false;
        return true;
    }

    public void showCurrentState(int[] currentState) {
        for (int value:currentState) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public int getChangedValue(Graph anotherGraph) {
        if (this.equals(anotherGraph)) return 0;
        for (int i = 0; i < nodes.size(); i++) {
            int anotherValue = anotherGraph.getNodeById(i).getValue();
            if (nodes.get(i).getValue() != anotherValue && anotherValue != 0)
                return anotherValue;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getValue() != graph.nodes.get(i).getValue())
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int v : this.getCurrentState()) {
            result = result * 10 + v;
        }
        return result;
    }
}
