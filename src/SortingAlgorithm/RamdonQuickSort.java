package SortingAlgorithm;

import java.util.Random;

public class RamdonQuickSort {

        public static void main(String[] args){
            int[] input = {3,1,11,8,21,2,6,12,103,3};
            quickSort(0, input.length-1, input);
            for(int i =0 ; i< input.length; i++){
                System.out.println(input[i]);
            }
        }

        public static void quickSort(int start, int end, int[] a){
            if(start<end) {
                int index = partition(start, end, a);
                quickSort(start, index - 1, a);
                quickSort(index + 1, end, a);
            }
            return;
        }

        protected static int partition(int start, int end, int[] a){
            Random rand = new Random();
            int median = rand.nextInt(end-start)+start;
            int pIndex=start;
            swap(median,end,a);
            int pivot = end;
            for(int i=start; i<= end-1; i++){
                if(a[i] <= a[pivot]){
                    swap(i, pIndex, a);
                    pIndex++;
                }
            }

            swap(pivot, pIndex,a);
            return pIndex;
        }

        protected static void swap(int s1, int s2, int[] a){
            int temp =a[s1];
            a[s1] = a[s2];
            a[s2] = temp;
        }
}
