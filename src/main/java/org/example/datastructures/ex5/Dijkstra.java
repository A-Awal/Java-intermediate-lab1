package org.example.datastructures.ex5;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Graph {
        int V;
        List<List<Node>> adjList;

        Graph(int V) {
            this.V = V;
            adjList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }



        void addEdge(int u, int v, int weight) {
            adjList.get(u).add(new Node(v, weight));
            adjList.get(v).add(new Node(u, weight)); // For undirected graph
        }
    }
    static class Node {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static void dijkstra(Graph graph, int src) {
        int V = graph.V;
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, (a, b) -> a.weight - b.weight);
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().node;
            sptSet[u] = true;

            for (Node it : graph.adjList.get(u)) {
                int v = it.node;
                int weight = it.weight;

                if (!sptSet[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

    }
}
