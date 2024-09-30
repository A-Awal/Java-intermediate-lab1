package org.example.datastructures.ex4;

public class Node {
    int node;
    int weight;

    Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Node [node=" + node + ", weight=" + weight + "]";
    }
}