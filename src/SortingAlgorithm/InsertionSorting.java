package SortingAlgorithm;
/*Best Case: Input is already sorted. So the line9 and line10 inside the loop are not executed.
T(n) = an + b*/
/*Worst Case: Input away is in reverse order. We must compare A[j] with each element in the entire sorted list
A[1,j-1].
T(n) = an^ + bn + c*/
/* the second number need to be swapped once times. A[2,...n] need to be swapped [1,..n-1] So this line should be
executed 1/2n(n-1) times*/

/*loop variant: the subarray [1,...j-1] consists of the elements originally in A[1...j-1] but in sorted order*/
/*Initialization:prior to first iteration, j=2. Therefore, subarray[1,...j-1] consists of A[1]. It's clearly always
soeted. */
/* Maintenance: It moves A[j-1],A[j-2] until the correct position A[j] is found. Thus, A[1,...j-1] contains the same
element but in sorted order*/
/*Termination: When j > n, the loop terminates. The subarray[1...n] contains of original array but in sorted order.*/
public class InsertionSorting {
    public int[] insertionSort(int array[]){
        for(int j = 1; j < array.length; j++){
            int key = array[j];
            int i = j - 1;
            while(i >= 0 && array[i] > key ){
                array[i+1] = array[i];
                i = i-1;
            }
            array[i+1] = key;
            System.out.print("loop" + j + ": ");
            for(int k = 0 ; k < array.length; k++)
                System.out.print(array[k] + " ");
                System.out.println();
        }
        return array;
    }

}
