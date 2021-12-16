package DisjointSet;

public class DisjointSet {
    private final int numSets;
    private final int[] parents;
    private final int[] sizes;
    public DisjointSet(int numSets){
        if(numSets < 0)
            throw new IllegalArgumentException("Number of elements must be non-negative");
        this.numSets = numSets;
        parents = new int[numSets];
        sizes = new int[numSets];
        for(int i = 0 ; i < numSets; i++){
            parents[i] = i;
            sizes[i] = 1;
        }
    }

    public int find(int element){
        if(element < 0 || element >= numSets){
            throw new IndexOutOfBoundsException();
        }
//        if(parents[element] != element){
//            parents[element] = find(parents[element]);
//        }
        int parent = parents[element];
        while(true){
            int grandparent = parents[parent];
            if(parent ==  grandparent){
                return parent;
            }
            //path compression
            parents[element] = grandparent;
            element = parent;
            parent = grandparent;
        }
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

    public static void main(String[] args) {
        int n = 5;
        DisjointSet disjointSet = new DisjointSet(n);
        disjointSet.union(0,2);
        disjointSet.union(4,2);
        disjointSet.union(1,3);
        if(disjointSet.inSameSet(4,0)){
            System.out.println("YES");
        }
        else{
            System.out.println("No");
        }

        if(disjointSet.inSameSet(1,0)){
            System.out.println("YES");
        }
        else{
            System.out.println("No");
        }

    }
}
