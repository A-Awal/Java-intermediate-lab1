package org.example.datastructures.ex4;

import java.util.ArrayList;
import java.util.List;

public class Graph {
        int numberOfVertices;
        List<List<Node>> adjList;

        Graph(int numberOfVertices) {
            this.numberOfVertices = numberOfVertices;
            adjList = new ArrayList<>();
            for (int i = 0; i < numberOfVertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int verticeA, int verticeB, int weight) {
            adjList.get(verticeA).add(new Node(verticeB, weight));
            // For undirected graph
            adjList.get(verticeB).add(new Node(verticeA, weight));
        }
}
