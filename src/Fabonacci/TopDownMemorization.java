package Fabonacci;

public class TopDownMemorization {
    public static int Fabonacci(int n){
        int[] memorization = new int[n+1];
        if(n < 2){
            return n;
        }
        if(memorization[n] != 0){
            return memorization[n];
        }
        memorization[n] = Fabonacci(n-1) + Fabonacci(n-2);
        return memorization[n];
    }
    public static void main(String[] args) {
        for(int i = 0; i <= 5; i++){
            System.out.println(Fabonacci(i));
        }
    }
}
