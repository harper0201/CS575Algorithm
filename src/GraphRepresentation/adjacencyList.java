package GraphRepresentation;
import java.util.LinkedList;


public class adjacencyList {
    static class Vertex{
        String name;
        public Vertex(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }

    }
    static class Edge {
        private Vertex source;
        private Vertex destination;
        private int weight;
        public Edge(Vertex source, Vertex destination, int weight) {
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
    }

    LinkedList<Edge> list = new LinkedList<>();
    public void addEdge(Vertex source, Vertex destination,int weight){
        Edge edge = new Edge(source,destination,weight);
        list.addFirst(edge);
        edge = new Edge(source,destination,weight);
        list.addFirst(edge);
    }

    public void printGraph(){
     for(Edge edge: list){
         System.out.println(edge.getSource().getName() + " is connected to " + edge.getDestination().getName() + " with " +
                 "weight " + edge.getWeight());
     }
    }

    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Vertex v6 = new Vertex("F");
        adjacencyList adjacencyList= new adjacencyList();
        adjacencyList.addEdge(v1,v2,3);
        adjacencyList.addEdge(v2,v3,4);
        adjacencyList.addEdge(v3,v4,5);
        adjacencyList.addEdge(v4,v5,6);
        adjacencyList.addEdge(v5,v6,7);
        adjacencyList.printGraph();
    }
}
