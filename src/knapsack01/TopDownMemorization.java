package knapsack01;

public class TopDownMemorization{
    private static int knapsack(int[] weights, int[] profits, int capacity, int index) {
        int[][] dp = new int[profits.length + 1][capacity + 1];
        //dp represents the maximun knapsack profits for capcity c calculated from first ith item
        if (capacity <= 0 || index >= profits.length) return 0;
        if (dp[index][capacity] != 0) return dp[index][capacity];
        int profits1 = 0;
        int profits2 = 0;
        if (weights[index] <= capacity) {
            profits1 = profits[index] + knapsack(weights, profits, capacity - weights[index], index + 1);
        }
        profits2 = knapsack(weights, profits, capacity, index + 1);
        dp[index][capacity] = Math.max(profits1, profits2);
        return dp[index][capacity];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3, 5};
        int[] profits = new int[]{1, 6, 10, 16};
        System.out.println(knapsack(weights, profits, 7, 0));
        int totalprofit = knapsack(weights, profits, 7,0);
    }
}
