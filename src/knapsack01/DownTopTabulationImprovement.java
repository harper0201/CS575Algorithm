package knapsack01;

public class DownTopTabulationImprovement {
    public static int knapsack(int[] weights, int[] profits, int capacity) {
        if (capacity <= 0 || profits.length == 0) return 0;
        // we only need two values from previous interation, dp[c],dp[c-wight[i]
        // dp[c - weight[i]] might be overridden if weight[i] > 0 and therefore we can't use this value for current
        // interation
        // reverse direction: c: capacity-->0
        int[] dp = new int[capacity +1];

        for(int c = 0; c < capacity; c++){
            if(weights[0] <= c){
                dp[c] = profits[0];
            }
        }
        for(int i = 1; i < profits.length; i++){
            for(int c = capacity; c >= 0; c--){
                int profit1 = 0;
                int profit2 = 0;
                if(weights[i] <= c){
                    profit1 = profits[i] + dp[c-weights[i]];
                }
                profit2 = dp[c];
                dp[c] = Math.max(profit1,profit2);
            }
        }


        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{2, 5, 10, 5};
        int[] profits = new int[]{40, 30, 50, 10};

    }
}
