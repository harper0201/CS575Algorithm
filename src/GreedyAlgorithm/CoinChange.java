package GreedyAlgorithm;

public class CoinChange {
    public static int[] CoinChange(int[] CoinValue,int sum){
        if(sum < 0 || CoinValue.length <0) return new int[0];
        int n = CoinValue.length;
        int[] CoinNumber = new int[n];
        for(int i = n-1; i>= 0; i--){
            while(sum >= CoinValue[i]){
                sum -= CoinValue[i];
                CoinNumber[i] ++;
            }
        }
        return CoinNumber;
    }

    public static void main(String[] args) {
        int[] CoinValue = new int[]{1, 5, 10, 25};
        int sum = 40;
        int[] CoinChange = CoinChange(CoinValue, sum);
        for (int i = 0; i < CoinChange.length; i++) {
            System.out.println("The number of coins with denominations " + CoinValue[i] + " is " + CoinChange[i]);
        }
    }
}
