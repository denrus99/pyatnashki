package com.company;

import java.util.ArrayList;

public class Node {
    private ArrayList<Node> connectedNodes = new ArrayList<Node>();
    private int id;
    private int value;

    public Node(int value, int id) {
        this.value = value;
        this.id = id;
    }

    public void connectWith(Node anotherNode) {
        if (this.connectedNodes.contains(anotherNode))
            return;
        this.connectedNodes.add(anotherNode);
        anotherNode.connectWith(this);
    }

    public boolean changeValueWith(Node anotherNode) {
        if (!this.connectedNodes.contains(anotherNode))
            return false;
        int temp = this.value;
        this.setValue(anotherNode.value);
        anotherNode.setValue(temp);
        return true;
    }

    private void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Node> getConnectedNodes(){
        return connectedNodes;
    }
}
