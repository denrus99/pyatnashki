package com.company;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes = new ArrayList<Node>();

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
//            if (i==0){
//                nodes.add(new Node(initialState[4], i));
//            }else if(i<4){
//                nodes.add(new Node(initialState[i-1], i));
//            }else if(i==4)
//            switch (i) {
//                case (0):
//                    nodes.add(new Node(initialState[4], i));
//                    break;
//                case (4):
//                    nodes.add(new Node(initialState[0], i));
//                    break;
//                default:
//                    nodes.add(new Node(initialState[i], i));
//                    break;
//            }
        }
        nodes.get(1).ConnectWith(nodes.get(2));
        nodes.get(1).ConnectWith(nodes.get(3));
        nodes.get(2).ConnectWith(nodes.get(3));
        nodes.get(2).ConnectWith(nodes.get(4));
        nodes.get(3).ConnectWith(nodes.get(5));
        nodes.get(4).ConnectWith(nodes.get(0));
        nodes.get(4).ConnectWith(nodes.get(6));
        nodes.get(5).ConnectWith(nodes.get(0));
        nodes.get(5).ConnectWith(nodes.get(7));
        nodes.get(6).ConnectWith(nodes.get(7));
//        nodes.get(0).ConnectWith(nodes.get(1));
//        nodes.get(0).ConnectWith(nodes.get(2));
//        nodes.get(1).ConnectWith(nodes.get(2));
//        nodes.get(1).ConnectWith(nodes.get(3));
//        nodes.get(2).ConnectWith(nodes.get(5));
//        nodes.get(3).ConnectWith(nodes.get(4));
//        nodes.get(3).ConnectWith(nodes.get(6));
//        nodes.get(4).ConnectWith(nodes.get(5));
//        nodes.get(5).ConnectWith(nodes.get(7));
//        nodes.get(6).ConnectWith(nodes.get(7));
    }

    public Node GetNodeByID(int ID) {
        for (int i = 0; i < this.nodes.size(); i++) {
            if (ID == this.nodes.get(i).GetID()) {
                return this.nodes.get(i);
            }
        }
        /* TODO */
        return new Node(0, 0);
    }

    public int[] GetCurrentState() {
        int[] result = new int[nodes.size()];
        for (int i = 0; i < result.length; i++) {
            if (i == 0)
                result[4] = nodes.get(i).GetValue();
            else if (i < 5)
                result[i - 1] = nodes.get(i).GetValue();
            else if (i == 4)
                result[i] = nodes.get(0).GetValue();
            else
                result[i] = nodes.get(i).GetValue();
        }
//        for (int i = 0; i < nodes.size(); i++) {
//            result[i] = nodes.get(i).GetValue();
//        }
        return result;
    }

    public ArrayList<Graph> GetNextStates() {
        ArrayList<Graph> result = new ArrayList<Graph>();
        for (Node emptyNode : nodes) {
            if (emptyNode.GetValue() == 0) {
                for (Node currentNode : emptyNode.GetConnectedNodes()){
                    Graph newState = new Graph(this.GetCurrentState());
                    newState.GetNodeByID(emptyNode.GetID()).ChangeValueWith(newState.GetNodeByID(currentNode.GetID()));
                    result.add(newState);
                }
            }
        }
        return result;
    }
}
