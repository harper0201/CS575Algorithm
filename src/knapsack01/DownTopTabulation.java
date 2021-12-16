package knapsack01;

    class DownTopTabulation {
        public static int knapsack(int[] weights, int[] profits, int capacity) {
            if(capacity<=0 ||profits.length == 0) return 0;
            int[][] dp = new int[profits.length][capacity+1];
            //base case
            //with 0 capacity, maxinum profits we can find for each subset is 0
            for(int i = 0; i < profits.length; i++){
                dp[i][0] = 0;
            }
            // if we have only one weight, we will take it if it is not more than capacity.
            for(int c = 0; c <= capacity; c++){
                if(weights[0] <= c){
                    dp[0][c] = profits[0];
                }
            }
            for(int i = 1; i < profits.length; i++){
                for(int c = 1; c <= capacity; c++){
                    int profit1 = 0;
                    int profit2 = 0;
                    if(weights[i] <=c){
                        //Include the item at index i if the weight is not more than capacity.
                        //we include its profit plus whatever profit we get from the remaining capacity
                        profit1 = profits[i] + dp[i-1][c - weights[i]];
                    }
                    //Exclude the item at index i.
                    //we will take whatever profit we get from subarray excludig item
                    profit2 = dp[i-1][c];
                    dp[i][c] = Math.max(profit1,profit2);
                }
            }


            printSelectedElements(dp,weights,profits,capacity);
            return dp[profits.length-1][capacity];
        }
        private static void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){
            //for every step, we have two options: include or skip item
            //if we skip item, we take profits from remaining items(the cell above it). If we include the item, we
            // jump into remaining profits to find more items.
            for(int i = 0; i < 4;i ++){
                for(int j = 0; j <= capacity; j++){
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }

            int totalprofits = dp[profits.length-1][capacity];
            for(int i = profits.length-1; i > 0; i--){
                if(totalprofits != dp[i-1][capacity]){
                    System.out.print(weights[i] + " ");
                    capacity -= weights[i];
                    totalprofits -= profits[i];
                }
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int[] weights = new int[]{2,5,10,5};
            int[] profits = new int[]{40,30,50,10};
            System.out.println(knapsack(weights,profits,16));
        }
    }

