package GraphAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class edge{
    private final int source;
    private final int destination;
    private final int weight;

    public edge(int source, int destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource(){
        return source;
    }

    public int getDestination(){
        return destination;
    }

    public int getWeight(){
        return weight;
    }
}

class graph {
    private final LinkedList<edge> edges;
    int v;
    int e;
    public graph(int v, int e){
        if(v < 0 || e < 0){
            throw new IllegalArgumentException();
        }
        this.v = v;
        this.e = e;
        this.edges = new LinkedList<>();
    }

    public LinkedList<edge> getEdges() {
        return edges;
    }

    public void addEdge(int source, int destination, int weight) {
        edge e = new edge(source, destination, weight);
        edges.addFirst(e);
    }
}
public class Kruskal {
    graph g;
    private final int[] parents;
    private final int[] sizes;

    public Kruskal(graph g){
        this.g = g;
        parents = new int[g.v];
        sizes = new int[g.v];
        for(int i = 0 ; i < g.v; i++){
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

    public int printMST(){
        PriorityQueue<edge> pq = new PriorityQueue<>(g.e, Comparator.comparingInt(edge::getWeight));
        for(edge e : g.getEdges()){
            pq.offer(e);
        }
        ArrayList<edge> MST = new ArrayList<>();
        while(!pq.isEmpty()){
            edge min = pq.poll();
            int x = find(min.getSource());
            int y = find(min.getDestination());
            if(!inSameSet(x,y)){
                MST.add(min);
                union(x,y);
            }
        }
        int total_weight = 0;
        for(edge mst : MST){
            System.out.println(mst.getSource() +
                    " - " + mst.getDestination() +
                    " weight: " + mst.getWeight());
            total_weight = total_weight + mst.getWeight();
        }
        return total_weight;
    }

    public static void main(String[] args) {
        int v = 4;
        int e = 5;
        graph g = new graph(v,e);
        g.addEdge(0,1,10);
        g.addEdge(0,2,6);
        g.addEdge(0,3,5);
        g.addEdge(1,3,15);
        g.addEdge(2,3,4);
        Kruskal kruskal = new Kruskal(g);
        System.out.println("total weight is " + kruskal.printMST() );
    }
    }




