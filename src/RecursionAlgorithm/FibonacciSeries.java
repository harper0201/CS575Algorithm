package RecursionAlgorithm;

import java.util.Scanner;

public class FibonacciSeries {
    public int fab(int n){
        if(n == 1 | n == 2 ){
            return 1;
        }
        else{
            return fab(n-1) + fab(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.print("input the value of n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        FibonacciSeries obj = new FibonacciSeries();
        System.out.print("the result is :" + obj.fab(n));
    }
    /*T(n) = 1 n <= 2
    T(n) = T(n-1) + T(n-2) n > 2
     */
}
