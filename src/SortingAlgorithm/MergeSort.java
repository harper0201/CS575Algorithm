package SortingAlgorithm;


/* Divide: Divide n element sequence to be sorted into two subsequence of n/2 elements.
T(1)
* Conquer: Sort the subsequence recursively using merge sort.
2T(n/2)
* Combine: Merge the two sorted subsequence to produce the sorted answer.
T(n)*/
/*loop variant: the subarray A[p,k-1] contains k-p the smallest elements of L[1...n+1] and R[1...n+1]
* A[i] and A[j] are the smallest element of the array that have not been copied back into A*/
/*initialization: prior to first iteration,k = p,the subarray is empty containing no elements. since i = j = 1,L[i]
and L[j] are the smallest element that have not been copied to A
Maintenance: let's consider L[i]< R[j],L[i] is the smallest element not yet copied to A. And A[p...k-1] contains k-p
smallest element.
 Termination: At termination, k = p + 1; The subarray A[p...k-1] which is A[p,..r] contains k-p smallest element of L
  and R in sorted order.*/
/*T(n) = nlgn*/
public class MergeSort {
    public void Merge(int[]array, int p, int q, int r){
        //create tempt array
        int [] left = new int[q - p + 1];
        int [] right = new int[r - q];

        //copy data to tempt array
        for(int i = 0; i < left.length; i++){
            left[i] = array[p + i];
        }
        for(int j = 0; j < right.length; j++){
            right[j] = array[q + j + 1];
        }

        //initialize the index and merge two tempt array
        int i = 0, j = 0, k = p;
        while(i < left.length && j < right.length){
                if (left[i] <= right[j]) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while(j < right.length){
            array[k++] = right[j++];
        }
        for(int meg = p ; meg <= r; meg ++){
            System.out.print(array[meg] + " ");
        }
        System.out.println();

    }
    public int[] mergeSort(int[] array,int p, int r){
            if(p < r){
                int q = p + (r-p)/2;
                mergeSort(array,p,q);
                mergeSort(array,q+1,r);
                Merge(array,p,q,r);
            }
            return array;
    }

}
