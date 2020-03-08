package com.company;

public class Main {

    public static void main(String[] args) {
        Graph model = new Graph(new int[]{1,2,3,4,0,5,6,7});
        Solver s = new Solver();
        s.resolve(new int[]{2,1,3,4,0,5,6,7});
    }


}
