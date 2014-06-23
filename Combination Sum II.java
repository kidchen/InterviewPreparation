public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return result;
        Arrays.sort(num);
        ArrayList<Integer> item = new ArrayList<Integer>();
        helper(num, result, item, target, 0, 0);
        return result;
    }
    
    void helper(int[] num, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int target, int step, int sum) {
        if(sum == target) {
            if(!result.contains(item)) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        // !!! DO NOT FORGET TO ADD "step >= num.length", because we use i+1 to skip to the next !!!
        } else if(sum > target || step >= num.length) {
            return;
        } else {
            for(int i = step; i < num.length; i++) {
                // skip the duplicate elements in num[]
                if(i > step && num[i] == num[i - 1]) continue;
                item.add(num[i]);
                // !!!!!! step is i !!!!!!
                helper(num, result, item, target, i + 1, sum + num[i]);
                item.remove(item.size() - 1);
            }
        }
    }
}
