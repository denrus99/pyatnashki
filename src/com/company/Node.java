package com.company;

import java.util.ArrayList;

public class Node {
    private ArrayList<Node> connectedNodes = new ArrayList<Node>();
    private int ID;
    private int value;
    private boolean checked;

    public Node(int value, int ID) {
        this.value = value;
        this.ID = ID;
        this.checked = false;
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
}
