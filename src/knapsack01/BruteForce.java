package knapsack01;


public class BruteForce {
    private static int knapsack(int[] weights, int[] profits, int capacity,int index) {
        if(capacity<=0 ||index >= profits.length) return 0;
        int profits1 = 0;
        int profits2 = 0;
        if(weights[index] <= capacity){
            profits1 = profits[index] + knapsack(weights,profits,capacity-weights[index],index+1);
        }
        profits2 = knapsack(weights,profits,capacity,index+1);
        return Math.max(profits1,profits2);
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,5};
        int[] profits = new int[]{1,6,10,16};
        System.out.println(knapsack(weights,profits,7,0));
    }
}
