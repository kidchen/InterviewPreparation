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

// O(2^n) time/space

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
            // only diff: skip duplicates
            if(i!=len && num[i]==num[i-1]){
                continue;
            }
            subset.add(num[i]);
            helper(num,result,subset,i+1);
            subset.remove(subset.size()-1);
        }
    }
}


// No recursion method:

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if(num == null || num.length == 0) {
            return result;
        }
        // don't forget to sort, and initial the start as 0
        Arrays.sort(num);
        int start = 0;
        for(int i = 0; i < num.length; i++) {
            int size = result.size();
            // start: when meet dup, we only add second half of the current elements in the result
            for(int j = start; j < size; j++) {
                ArrayList<Integer> item = new ArrayList<Integer>(result.get(j));
                item.add(num[i]);
                result.add(item);
            }
            if(i < num.length - 1 && num[i] == num[i + 1]) {
                // !!! when meet dup, start from current size !!!
                start = size;
            } else {
                // don't forget to re-set 0 if no dup
                start = 0;
            }
        }
        return result;
    }
}
