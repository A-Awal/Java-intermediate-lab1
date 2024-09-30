package org.example.datastructures.ex4;


public class DFSWithNode {

    public void dfs(Graph graph, int startVertex) {
        int numVertices = graph.numberOfVertices;
        boolean[] visited = new boolean[numVertices];

        System.out.println(graph.adjList.get(startVertex));
        dfsRecursive(graph, startVertex, visited);
    }

    private void dfsRecursive(Graph graph, int vertex, boolean[] visited) {
        visited[vertex] = true;


        for (Node neighbor : graph.adjList.get(vertex)) {
            if (!visited[neighbor.node]) {
                dfsRecursive(graph, neighbor.node, visited);
            }
        }
    }
}
