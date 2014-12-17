/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 

design an algorithm to find the maximum profit.
*/

// DP Solution with Global&Local, 
// O(n) time & O(1) space

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int local = 0;
        int global = 0;
        for(int i = 1; i < prices.length; i++) {
        	// local: is current transaction > or < 0
            local = Math.max(local + prices[i] - prices[i - 1], 0);
            global = Math.max(local, global);
        }
        return global;
    }
}


// return dates

public class StockI {
	
	public static void main(String[] args) {
		int[] prices = {9,8,7,6,5, 10};
		maxProfit(prices);
	}

    public static void maxProfit(int[] prices) {
       if(prices.length == 0) {
    	   return;
       }
       int min = prices[0];          
       int maxProfit = 0;               
       int[] dates = new int[2];
       int buyDate = 0;      
       for(int i=1; i<prices.length; i++){            
            if(prices[i] < min) {
                 min = prices[i];
                 buyDate = i;
            }          
            int currentProfit = prices[i] - min;
            if(currentProfit > maxProfit) {
                 maxProfit = currentProfit;
                 dates[0] = buyDate; dates[1] = i;
            }
       }
       System.out.println(dates[0] + " , " + dates[1]);
       return;
   }
}
