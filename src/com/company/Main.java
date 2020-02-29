package com.company;

public class Main {

    public static void main(String[] args) {
        Graph model = new Graph(new int[]{1,2,3,4,0,5,6,7});
        int[] currentState = model.GetCurrentState();
        ShowCurrentState(currentState);
        model.GetNodeByID(4).ChangeValueWith(model.GetNodeByID(0));
        System.out.println("\nNew state");
        currentState = model.GetCurrentState();
        ShowCurrentState(currentState);

    }

    public static void ShowCurrentState(int[] currentState){
        for (int i = 0; i < currentState.length; i++) {
            System.out.print(currentState[i] + "\t");
        }
    }
}
