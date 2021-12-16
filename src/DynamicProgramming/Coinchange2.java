package DynamicProgramming;

public class Coinchange2 {

    public static int CoinChange(int sum, int[] CoinValue){
        if(sum < 0 || CoinValue.length <0) return 0;
        int[][]dp = new int[CoinValue.length][sum+1];
        //base case
        for(int i = 0; i < CoinValue.length; i++){
            dp[i][0] = 0;
        }
        for(int n = 1; n <= sum; n++){
            dp[0][n] = n;
            //System.out.println("i:"+ "0" + "j:" + n + " " + dp[0][n]);
        }
        //optimal solution for subproblem
        for(int i = 1; i < CoinValue.length; i++){
            for(int j = 1; j <= sum; j++){
                if(j - CoinValue[i] >= 0){
                    //coins avaliable
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-CoinValue[i]] + 1);

                }
                else{
                    //coins unavaliable
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        PrintSelectedElements(dp,CoinValue,sum);
        return dp[CoinValue.length-1][sum];

    }
    public static void PrintSelectedElements(int[][]dp, int[]CoinValue, int sum){
        for(int i = 0; i < CoinValue.length; i++){
            for(int j = 0; j <= sum; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("the minimum number of coins is " + dp[CoinValue.length-1][sum]);

        int x = CoinValue.length-1;
        int y = sum;
        while(y > 0){
            if(dp[x][y] == dp[x-1][y]){
                x--;
            }
            else{
                System.out.println("coin with denomination " + CoinValue[x] + " are selected. ");
                y -= CoinValue[x];
            }
        }

    }
    public static void main(String[] args) {
        int[] CoinValue = new int[]{1,5,11};
        int k = CoinValue.length;
        int sum = 15;
        CoinChange(sum, CoinValue);
    }
}
