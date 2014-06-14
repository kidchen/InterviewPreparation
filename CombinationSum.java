public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates.length == 0 || candidates == null) return result;
        // !!! don't forget to sort !!!
        Arrays.sort(candidates);
        ArrayList<Integer> set = new ArrayList<Integer>();
        helper(result, set, candidates, target, 0, 0);
        return result;
    }
    
    void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> set, int[] candidates, int target, int sum, int step){
        if(sum == target){
            if(!result.contains(set)){
                // use new to keep elements in set
                result.add(new ArrayList<Integer>(set));
            }
            return;
        }else if(sum > target){
            return;
        }else{
            for(int i = step; i < candidates.length; i++){
                set.add(candidates[i]);
                // !!! step is i !!!
                helper(result, set, candidates, target, sum + candidates[i], i);
                // !!! remove last put element in set !!!
                set.remove(set.size() - 1);
            }
        }
    }
}
