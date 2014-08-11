/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        // !!! don't forget to sort !!!
        Arrays.sort(num);
        helper(num, result, subset, 0);
        return result;
    }
    
    void helper(int[] num, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int len){
        // !!! have to use new ArrayList, because subset will be changed later !!!
        result.add(new ArrayList<Integer>(subset));
        for(int i=len; i<num.length; i++){
            // skip duplicates
            if(i!=len && num[i]==num[i-1]){
                continue;
            }
            subset.add(num[i]);
            helper(num,result,subset,i+1);
            subset.remove(subset.size()-1);
        }
    }
}
