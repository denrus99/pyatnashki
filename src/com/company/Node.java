package com.company;

import java.util.ArrayList;

public class Node {
    private ArrayList<Node> connectedNodes = new ArrayList<Node>();
    private int ID;
    private int value;

    public Node(int value, int ID) {
        this.value = value;
        this.ID = ID;
    }

    public void ConnectWith(Node anotherNode) {
        if (this.connectedNodes.contains(anotherNode))
            return;
        this.connectedNodes.add(anotherNode);
        anotherNode.ConnectWith(this);
    }

    public boolean ChangeValueWith(Node anotherNode) {
        if (!this.connectedNodes.contains(anotherNode))
            return false;
        int temp = this.value;
        this.ChangeValue(anotherNode.value);
        anotherNode.ChangeValue(temp);
        return true;
    }

    private void ChangeValue(int value) {
        this.value = value;
    }

    public int GetValue() {
        return this.value;
    }

    public int GetID() {
        return this.ID;
    }

    public ArrayList<Node> GetConnectedNodes(){
        return connectedNodes;
    }
}
