package RecursionAlgorithm;

import java.util.Scanner;

public class BinarySearch {
    public int BinarySearch(int array[],int low,int high){
        if(high >= low){
            int mid = (high + low)/2;
            if(mid == array[mid-1]){
                return mid;
            }
            else if(mid > array[mid-1]){
                return BinarySearch(array,mid+1,high);
            }
            else{
                return BinarySearch(array,low,mid-1);
            }
        }
        return -1;
    }

    public static void main(String args[]){
        System.out.print("sorted list = ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        String split_t[] = input.substring(1,input.length()-1).split(",");
        int [] array = new int[split_t.length];
        for(int i = 0; i < split_t.length; i++){
            array[i] = Integer.valueOf(split_t[i]);
        }
        BinarySearch obj = new BinarySearch();
        int result = obj.BinarySearch(array,1,array.length-1);
        if(result == -1){
            System.out.print("There is no such index");
        }
        else{
            System.out.print("Element found at " + result);
        }
    }
}


