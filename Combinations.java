/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

// np, O(n^k) time

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// write your code here
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> items = new ArrayList<Integer>();
		if(n < 1 || k < 1) {
		    return result;
		}
		helper(n, k, result, items, 1);
		return result;
    }
    
    private void helper(int n, int k, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> items, int start) {
        if(items.size() == k) {
            result.add(new ArrayList<Integer>(items));
            return;
        }
        for(int i = start; i <= n; i++) {
            items.add(i);
            helper(n, k, result, items, i + 1);
            items.remove(items.size() - 1);
        }
    }
}
