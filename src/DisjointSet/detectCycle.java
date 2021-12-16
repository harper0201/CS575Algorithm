package DisjointSet;

import java.util.LinkedList;

class Edge{
    private final int source, destination;
    public Edge(int source, int destination){
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }
}

class Graph{
    LinkedList<Edge> edges;
    public Graph(){
        edges = new LinkedList<>();
    }

    public void addEdge(int source, int destination){
        Edge edge = new Edge(source,destination);
        edges.addFirst(edge);
    }

    public LinkedList<Edge> getEdges(){
        return edges;
    }
}

public class detectCycle{
    int[] parents;
    int[] sizes;
    int vertex;
    public detectCycle(int vertex){
        this.vertex = vertex;
        parents = new int[vertex];
        sizes = new int[vertex];
        for(int i = 0 ; i < vertex; i++){
            parents[i] = i;
            sizes[i] = 1;
        }
    }

    public int find(int element){

        if(parents[element] != element){
            parents[element] = find(parents[element]);
        }
        return parents[element];
    }

    public void union(int element1, int element2){
        int root1 = find(element1);
        int root2 = find(element2);
        if(root1 == root2){
        }
        else if(sizes[root1] < sizes[root2]){
            parents[root1] = root2;
        }
        else if(sizes[root2] < sizes[root1]){
            parents[root2] = root1;
        }
        else{
            parents[root2] = root1;
            sizes[root1]++;
        }
    }

    public boolean inSameSet(int element1, int element2){
        return find(element1) == find(element2);
    }

    public boolean isCycle(Graph graph){
        for(Edge edge: graph.getEdges()){
            int x = find(edge.getSource());
            int y = find(edge.getDestination());
            if(inSameSet(x,y)){
                return true;
            }
            union(x,y);
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 3;
        Graph graph = new Graph();
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,2);
        detectCycle detectCycle = new detectCycle(V);
        if(detectCycle.isCycle(graph)){
            System.out.println("graph contains a cycle");
        }
        else{
            System.out.println("graph doesn't contains a cycle");
        }

    }
}
