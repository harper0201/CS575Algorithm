package GraphAlgorithm;

import java.util.Scanner;

public class dijkstra {
    int vertex;
    char []nodes;
    int[][] matrix;


    public dijkstra(int vertex){
        this.vertex = vertex;
        this.nodes = new char[]{'x', 'y', 'z', 'w', 'v', 'u'};
        this.matrix = new int[vertex][vertex];
    }

    public void addEdges(char source, char destination, int weight){
        for(int i = 0 ; i < vertex; i++){
            for(int j = 0; j < vertex;j++){
                if(source == nodes[i] && destination == nodes[j]){
                    matrix[i][j]  = weight;
                    matrix[j][i] = weight;
                }
            }
        }
    }

    public int findMin(boolean[]isvisted, int[]distance,int count){
        int minDistance = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < vertex; i++){
            if(!isvisted[i] &&distance[i] < minDistance){
                minDistance = distance[i];
                minIndex = i;
            }
        }
        isvisted[minIndex] = true;
        System.out.print("step" + count + ": ");
        for(int i = 0; i < vertex; i++){
            if(isvisted[i]){
                System.out.print(nodes[i]);
            }
        }
        return minIndex;
    }

    public void printTable(char source){
        int[] distance = new int[vertex];
        boolean[] isvisited = new boolean[vertex];
        char [] previous = new char[vertex];

        //initialization
        System.out.print(" step ");
        System.out.print(" N  ");
        for (int i = 0; i < vertex; i++) {
            previous[i] =' ';
            if(nodes[i] != source){
                System.out.print(" D(" + nodes[i] + ") ");
            }
        }
        System.out.println("    conclusion   ");
        for(int i = 0; i < vertex; i++){
            if(source == nodes[i]){
                isvisited[i] = true;
                System.out.print("step0: ");
                System.out.print(nodes[i]+ " ");
                for(int j = 0; j < vertex; j++){
                    if(matrix[i][j] != 0 && !isvisited[j]){
                        distance[j] = matrix[i][j];
                        previous[j] = nodes[i];
                        System.out.print(" ("+ nodes[i]+ "," + distance[j] + ") ");
                    }
                    else if (matrix[i][j] == 0 && !isvisited[j]){
                        distance[j] = Integer.MAX_VALUE;
                        System.out.print(distance[j]+ " ");
                    }
                }
            }
            else{
                isvisited[i] = false;
            }
        }

        System.out.println();
        int count = 0;
        for(int j = 0 ; j < vertex-1; j++){
            count ++;
            int minIndex = findMin(isvisited,distance,count);

            for(int i = 0; i < vertex; i++){
                if(matrix[minIndex][i] != 0 && !isvisited[i]){
                    if(distance[i] > distance[minIndex] + matrix[minIndex][i]){
                        distance[i] = distance[minIndex] + matrix[minIndex][i];
                        previous[i] = nodes[minIndex];
                        System.out.print(" ("+ nodes[minIndex] + "," + distance[i] + ") ");
                    }
                    else{
                        System.out.print(" ("+  (previous[i]) + "," + distance[i] + ") ");
                    }
                }
                else if (matrix[minIndex][i] == 0 && !isvisited[i]){
                    System.out.print(" ("+ (previous[i]) + "," + distance[i] + ") ");
                }
                else if(isvisited[i] && nodes[i] != source){
                    System.out.print(" " + "Done!" + " ");
                }
            }
            System.out.print("     ");
            System.out.println("the route from " + source + " to " + nodes[minIndex] + " is " + distance[minIndex]);
        }
    }

    public void printGraph(){
        for(int i = 0 ; i < vertex; i++){
            for(int j = 0; j < vertex;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        dijkstra dijkstra = new dijkstra(6);
        dijkstra.addEdges('u','x',3);
        dijkstra.addEdges('u','v',6);
        dijkstra.addEdges('x','v',7);
        dijkstra.addEdges('u','w',7);
        dijkstra.addEdges('v','w',8);
        dijkstra.addEdges('x','w',5);
        dijkstra.addEdges('x','y',9);
        dijkstra.addEdges('w','y',3);
        dijkstra.addEdges('w','z',8);
        dijkstra.addEdges('y','z',9);

        //dijkstra.printGraph();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the source");
        char source = scanner.next().charAt(0);
        dijkstra.printTable(source);

    }

}
