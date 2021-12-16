package SortingAlgorithm;
/*Divide:Partition the array A[p,r] into two subarray A[p...q-1] and A[q+1...r] such that each element is less or
equal than A[q] which is less or equal to each element in A[q+1,...r]
Conquer:Sort two subarrays and A[q+1,...r] by recursive calls to quicksort
Combine: Because the subarray are already sorted , no work is needed to combine: the entirw array A[p...r] is sorted.*/

/*Worst Case: one subproblem with n-1 elements and one with 0 element. unbalanced partition occurs in each recursive
call. T(n^2)
Best Case: partition produce two subproblems, each of size no more than n/2. T(n) = n*lgn */

/*loop variant: if p<= k<=i, A[k]<=key; if i+1<=k<=j-1, A[k]>key; if k=r,A[k]=key;
Initialization: prior to first iteration of the loop, i=p-1 and j=p. There are no values between p and i as well as
i+1 and j-1; The third condition are met.
Maintenance: if A[j] > key, only action is to increase j, condition2 are met. if A[j] < key, increment in i, swap
A[j] and A[i], then increment in j. All conditions are met.
Termination: j = r+1; hence every element in one of three groups.
 */
public class QuickSort {
    static void Swap(int[]array,int l, int r){
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;

    }
    public int Partition(int[]array, int l, int r){
        int key = array[r];
        int i = l -1;
        for(int j = l; j <= r-1; j++){
            if(array[j] < key){
                i = i + 1;
                Swap(array,i,j);
            }
        }
        Swap(array,i+1,r);
        for(int t = 0 ; t < array.length; t++){
            System.out.print(array[t] + " ");
        }
        System.out.println();
        return (i + 1);
    }
    public int[] quickSort(int[] array,int l, int r){
        if(l < r){
            int q = Partition(array,l,r);
            quickSort(array,l,q-1);
            quickSort(array,q+1,r);
        }
        return array;
    }

}
