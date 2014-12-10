/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

// O(n) time, O(1) space

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int[] local = new int[3];
        int[] global = new int[3];
        for(int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            // !!! have to do it in -- way !!!
            for(int j = 2; j >= 1; j--) {
                /*
                local:
                global[j-1] + Math.max(diff, 0): in global, we sell stock on day j with one trans 
                                            (j-1 means that we didn't sell it from first buy(j-1), we sell it until this time)
                local[j] + diff: the profit we sell stock on day j
                */
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }
}


// follow up: k time:
// O(nk) time, O(k) space

public class Solution {
    public int maxProfit(int[] prices) {
        return max(prices, 2);
    }
    // k: k times transactions
    public int max(int[] prices, int k) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        int[][] local = new int[len][k+1];
        int[][] global = new int[len][k+1];
        for(int i=1; i<len; i++) {
            int diff = prices[i] - prices[i-1];
            for(int j=1; j<=k; j++) {
            /*
             * local[i][j]: max profit till i day, j transactions, where there is transaction happening on i day
             * global[i][j]: max profit across i days, j transactions
            */
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff,0), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
}
