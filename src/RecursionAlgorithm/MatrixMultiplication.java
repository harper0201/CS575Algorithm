package RecursionAlgorithm;

import java.util.Arrays;
/*T(n) = 8*T(n/2) + n^2
* T(n) = n^3
* Divide: divide into smaller matrix
* Conquer: recursive calls
* Combine: addition of matrix */
public class MatrixMultiplication {
    public static int[][] multiply(int[][] A, int[][] B, int rowA, int colA, int rowB, int colB, int size){
        int [][] C = new int[size][size];
        if(size == 1){
            C[0][0] = A[rowA][colA]*B[rowB][colB];
        }
        else{
            int newsize = size/2;
            // C11 = A11*B11 + A12*B21
            add(C,multiply(A,B,rowA,colA,rowB,colB,newsize),multiply(A,B,rowA,colA+newsize,rowB+newsize,colB,newsize),
                    0,0);
            // C12 = A11*B12 + A12*B22
            add(C,multiply(A,B,rowA,colA,rowB,colB+newsize,newsize),multiply(A,B,rowA,colA+newsize,rowB+newsize,
                    colB+newsize,
                    newsize),0,newsize);
            // C21 = A21*B11 + A22*B21
            add(C, multiply(A, B, rowA + newsize, colA, rowB, colB, newsize), multiply(A, B, rowA + newsize, colA + newsize, rowB + newsize, colB, newsize),
                    newsize, 0);
            // C22 = A21 * B12 + A22 * B22
            add(C, multiply(A, B, rowA + newsize, colA, rowB, colB + newsize, newsize),multiply(A, B, rowA + newsize, colA + newsize, rowB + newsize, colB + newsize, newsize),
                    newsize, newsize);
        }
        return C;
    }
    public static void add(int[][]C, int[][]A, int[][]B, int rowC, int colC){
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                C[i + rowC][j + colC] = A[i][j] + B[i][j];
            }
        }
    }
    public static void main(String[] args) {
        int [][] A = new int[][]{{2,1},{3,5}};
        int [][] B = new int[][]{{3,1},{2,4}};
        //print 2-D array
        System.out.print(Arrays.deepToString(multiply(A,B,0,0,0,0,A.length)));
    }
}
