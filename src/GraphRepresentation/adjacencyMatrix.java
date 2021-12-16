package GraphRepresentation;

public class adjacencyMatrix {
    int vertex;
    int matrix[][];

    public adjacencyMatrix(int vertex){
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }
    public void addEdge(int source, int destination, int weight){
        matrix[source][destination] = weight;
        matrix[destination][source] = weight;
    }

    public void printGraph(){
        System.out.println("Graph(adjacency Matrix");
        for(int i = 0; i < vertex; i++){
            for(int j = 0; j < vertex; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < vertex; i++){
            System.out.print(i + " is connected to ");
            for(int j = 0; j < vertex; j++){
                if(matrix[i][j] != 0){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        adjacencyMatrix graph = new adjacencyMatrix(5);
        graph.addEdge(0, 1,1);
        graph.addEdge(0, 4,2);
        graph.addEdge(1, 2,3);
        graph.addEdge(1, 3,4);
        graph.addEdge(1, 4,5);
        graph.addEdge(2, 3,6);
        graph.addEdge(3, 4,7);
        graph.printGraph();
    }

}
