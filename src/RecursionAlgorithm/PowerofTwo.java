package RecursionAlgorithm;

import java.util.Scanner;

public class PowerofTwo {
    public int powerofTwo(int n){
        if(n == 0)
            return 1;
        else{
            return 2*powerofTwo(n-1);
        }
    }
    public static void main(String[] args) {
        System.out.print("input the value of n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PowerofTwo obj = new PowerofTwo();
        System.out.print("result is " + obj.powerofTwo(n));
    }
}
/*T(n) = 1 if n == 0
T(n) = T(n-1)  if n > 0 */