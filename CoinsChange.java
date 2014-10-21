/*
Find Minimum Number of coins

Suppose I am asked to find the minimum number of coins you can find for a particular sum. 
That is, say, coins are 1, 3, 5, the sum is 10, so the answer should be 2, since I can use the coin 5 twice.
*/

// O(mn), O(n) space cost

public class Coins {
	public static void main(String[] args) {
		int target = 10;
		int[] coins = {5,1,8};
		System.out.println(findMinCoins(coins, target));
	}
	
	public static int findMinCoins(int[] coins, int sum) {
	    int[] minCoins = new int[sum + 1];
	    for (int s = 1; s <= sum; s++) {
	        minCoins[s] = Integer.MAX_VALUE - 1;
	    }

	    for (int s = 1; s <= sum; s++) {
	        for (int coin : coins) {
	            if (coin <= s) {
	                minCoins[s] = Math.min(minCoins[s], minCoins[s - coin] + 1);
	            }
	        }
	    }
	    return minCoins[sum];
	}
}


/****** follow up ******/

/*
How many ways can we make the change?
*/

// O(mn), O(n) space cost

        public static int findMinCoins(int[] coins, int sum) {
		
		    // result[i] will be storing the number of solutions for
		    // value i. We need sum+1 rows as the table is consturcted
		    // in bottom up manner using the base case (sum = 0)
		    int[] result = new int[sum + 1];
		 
		    // Initialize all table values as 0		 
		    // Base case (If given value is 0)
		    result[0] = 1;
		 
		    // Pick all coins one by one and update the result[] values
		    // after the index greater than or equal to the value of the
		    // picked coin
		    for(int i=0; i<coins.length; i++)
		        for(int j=coins[i]; j<= sum; j++)
		            result[j] += result[j-coins[i]];		 
		    return result[sum];
	    }
