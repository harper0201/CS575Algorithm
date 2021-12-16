package SortingAlgorithm;
import java.util.Scanner;

public class SortingAlgorithm {
    public void PrintArray(int array[]){
        System.out.print("the sorted array is: ");
        for(int j = 0 ; j < array.length; j++){
            System.out.print(array[j] + " ");
        }
    }
    public static void main(String[] args) {
        System.out.print("input the number of items:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int [] array = new int[n];
        System.out.print("input the array:");
        for(int i = 0 ; i < n; i++){
            array[i] = scanner.nextInt();
        }
        SortingAlgorithm obj = new SortingAlgorithm();
        System.out.print("sorting method:");
        String sort = scanner.next();
        switch (sort){
            case "I":
                InsertionSorting insertionSorting = new InsertionSorting();
                obj.PrintArray(insertionSorting.insertionSort(array));
                break;
            case "M":
                MergeSort mergeSort = new MergeSort();
                obj.PrintArray(mergeSort.mergeSort(array,0,array.length-1));
                break;
            case "Q":
                QuickSort quickSort = new QuickSort();
                obj.PrintArray(quickSort.quickSort(array,0,array.length-1));
                break;
            case "S":
                SelectionSort selectionSort = new SelectionSort();
                obj.PrintArray(selectionSort.selectionSort(array));
        }
    }
}
