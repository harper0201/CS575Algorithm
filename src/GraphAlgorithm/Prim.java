package GraphAlgorithm;

import java.util.*;
// basic Attribution and methods of vertex
class Vertex{
    private final String name;
    private boolean color;
    private int key;
    private Vertex previousVertex;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getKey(){
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }


    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", key=" + key +
                ", previousVertex=" + previousVertex +
                '}';
    }
}

// basic Attribution and methods of edge
class Edge{
    private final Vertex source;
    private final Vertex destination;
    private final int weight;

    public Edge(Vertex source, Vertex destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getSource(){
        return source;
    }

    public Vertex getDestination(){
        return destination;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}

// basic Attribution and methods of graph
class Graph {
    private final LinkedList<Edge> edges;
    int size;
    public Graph(int size){
        this.size = size;
        this.edges = new LinkedList<>();
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        edges.addFirst(edge);
        edge = new Edge(destination, source, weight);
        edges.addFirst(edge);
    }

}

//prim algorithm
public class Prim {

    static final boolean WHITE = false;
    static final boolean BLACK = true;

    public void decreaseKey(PriorityQueue<Vertex>pq, Vertex distination) {
        for (Vertex temp : pq) {
            if (Objects.equals(temp.getName(), distination.getName())) {
                pq.remove(temp);
                temp.setKey(distination.getKey());
                pq.offer(temp);
                break;
            }
        }
    }

    public int primTable(Vertex source, Graph graph) {
        int totalWeight = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(Vertex::getKey));

        for (Edge edge : graph.getEdges()){
            if(!pq.contains(edge.getSource())){
                pq.offer(edge.getSource());
            }
        }

        for(Vertex vertex : pq){
           vertex.setColor(WHITE);
            vertex.setPreviousVertex(null);
            vertex.setKey(Integer.MAX_VALUE);
        }

        for(Vertex vertex : pq){
            if(vertex == source){
                pq.remove(vertex);
                vertex.setKey(0);
                pq.offer(vertex);
                break;
            }
        }

        System.out.println("The spanning mining tree is :");
        while(!pq.isEmpty()){
            Vertex extractVertex = pq.poll();
            if(extractVertex.getPreviousVertex() != null){
                System.out.println(extractVertex.getPreviousVertex().getName() + "-" + extractVertex.getName() + " with " +
                        extractVertex.getKey());
                totalWeight = totalWeight + extractVertex.getKey();
            }
            for(Edge edge : graph.getEdges()){
                if(edge.getSource() == extractVertex && edge.getDestination() != null){
                    if(edge.getDestination().getColor() == WHITE && edge.getWeight() < edge.getDestination().getKey()){
                        edge.getDestination().setKey(edge.getWeight());
                        decreaseKey(pq,edge.getDestination());
                        edge.getDestination().setPreviousVertex(edge.getSource());
                    }
                }
            }
            extractVertex.setColor(BLACK);
        }
       return totalWeight;
    }

    public static void main(String[] args) {
        Vertex x = new Vertex("x");
        Vertex y = new Vertex("y");
        Vertex z = new Vertex("z");
        Vertex v = new Vertex("v");
        Vertex w = new Vertex("w");
        Vertex u = new Vertex("u");
        Graph graph = new Graph(6);
        graph.addEdge(u,v,6);
        graph.addEdge(u,x,3);
        graph.addEdge(v,x,7);
        graph.addEdge(u,w,7);
        graph.addEdge(v,w,8);
        graph.addEdge(x,w,5);
        graph.addEdge(x,y,9);
        graph.addEdge(w,y,3);
        graph.addEdge(w,z,8);
        graph.addEdge(y,z,9);
        Prim prim = new Prim();
        System.out.print("The total cost is " +  prim.primTable(x,graph));
    }
}
