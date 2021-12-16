package DynamicProgramming;

public class knapsack {

    public static int MaxKnapsack(int weights[], int values[], int capacity){
        if(capacity<=0 ||values.length == 0) return 0;
        int[][] dp = new int[values.length][capacity+1];
        //base case
        for(int i = 0; i < values.length; i++){
            dp[i][0] = 0;
        }
        for(int c = 0; c <= capacity; c++){
            if(weights[0] <= c){
                dp[0][c] = values[0];
                //System.out.println("i:"+ 0 + "c:" + c + " " + dp[0][c]);
            }
            else{
                dp[0][c] = 0;
            }
        }
        //optimal solution for subproblem
        for(int i = 1; i < values.length; i++){
            for(int c = 1; c <= capacity; c++){
                if(weights[i] <=c){
                    //Include the item
                    dp[i][c] = Math.max(values[i] + dp[i-1][c - weights[i]],dp[i-1][c]);
                    //System.out.println("i:"+ i + "j:" + c + " " + dp[i][c]);
                }
                else{
                    //Exclude the item
                    dp[i][c] = dp[i-1][c];
                    //System.out.println("i:"+ i + "j:" + c + " " + dp[i][c]);
                }
            }
        }
        PrintSelectedElements(dp,weights,values,capacity);
        return dp[values.length-1][capacity];
    }
    private static void PrintSelectedElements(int dp[][], int[] weights, int[] values, int capacity){
        for(int i = 0; i < weights.length; i++){
            for(int j = 0; j <= capacity; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int TotalValue = dp[values.length-1][capacity];
        for(int i = values.length; i > 0; i--){
            if(TotalValue != dp[i-1][capacity]){
                System.out.println("item with weight " + weights[i] + " put in the bag.");
                capacity -= weights[i-1];
                TotalValue -= values[i-1];
            }
        }
    }

    public static void main(String[] args) {
        int[] weights = new int[]{2, 5, 10, 5};
        int[] values = new int[]{40, 30, 50, 10};
        System.out.println("the maximum value is " + MaxKnapsack(weights,
                values, 16));
    }
}
