package Fabonacci;

public class BruteForce {
    public static int Fabonacci(int n){
        if(n < 2){
            return n;
        }
        else {
            return Fabonacci(n-1) + Fabonacci(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.println(Fabonacci(5));
    }
}
