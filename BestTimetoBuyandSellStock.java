/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 

design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int min = prices[0], profit = 0;
        for(int i = 1; i < prices.length; i++){
            profit = prices[i]-min > profit ? prices[i]-min : profit;
            min = prices[i] < min ? prices[i] : min;
        }
        return profit;
    }
}


// DP Solution with Global&Local, O(n) & O(1)

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int local = 0;
        int global = 0;
        for(int i = 1; i < prices.length; i++) {
            local = Math.max(local + prices[i] - prices[i - 1], 0);
            global = Math.max(local, global);
        }
        return global;
    }
}
