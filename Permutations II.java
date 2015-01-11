/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

// 

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> set = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        // !!! DO NOT FORGET TO SORT !!!
        Arrays.sort(num);
        helper(num, set, visited, result);
        return result;
    }
    
    void helper(int[] num, ArrayList<Integer> set, boolean[] visited, ArrayList<ArrayList<Integer>> result) {
        if(set.size() == num.length) {
            result.add(new ArrayList<Integer>(set));
            return;
        }
        for(int i = 0; i < num.length; i++) {
            // !!! don't forget to add if() !!!
            if(!visited[i]){
                set.add(num[i]);
                visited[i] = true;
                helper(num, set, visited, result);
                visited[i] = false;
                set.remove(set.size() - 1);
                // check dup in the if() clause
                while(i+1 < num.length && num[i] == num[i+1]){
                    i++;
                }
            }
        }
    }
}
