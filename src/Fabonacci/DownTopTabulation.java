package Fabonacci;

public class DownTopTabulation {
    public static int[] Fabonacci(int n){
        if(n < 2){
            return new int[0];
        }
        int[] dp = new int[n+1];
        //base case
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp;
    }
    public static void main(String[] args) {
        int[] fabonacci = Fabonacci(5);
        for(int f:fabonacci){
            System.out.println(f);
        }
    }
}
