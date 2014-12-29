/*
Given a list of numbers, return all possible permutations.

Example
For nums [1,2,3], the permutaions are: 

[
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
]
*/

// NP: O(2^n)
// recursion: use extra space to store the used elements

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> item = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.size()];
        helper(nums, result, item, used);
        return result;
    }
    
    private void helper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, boolean[] used) {
        if(item.size() == nums.size()) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = 0; i < nums.size(); i++) {
            if(!used[i]) {
                used[i] = true;
                item.add(nums.get(i));
                helper(nums, result, item, used);
                item.remove(item.size() - 1);
                used[i] = false;
            }
        }
    }
}


// iteration: got 0-i elements' permutation, when we got i+1th, add the new one to each previous items

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int i = 0; i<num.length; i++){
            // every time use "new" to remove old result until i=num.length-1
            ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
            // find places to insert new number
            for(ArrayList<Integer> temp : res){
                for(int j=0; j<temp.size()+1; j++){
                    // add one solution to helper-->cur (temp should be reused later in this loop)
                    // temp stores last round results. e.g. [2,1][1,2]
                    temp.add(j,num[i]);
                    ArrayList<Integer> helper = new ArrayList<Integer>(temp);
                    cur.add(helper);
                    temp.remove(j);
                }
            }
            // new for refresh
            res = new ArrayList<ArrayList<Integer>>(cur);
        }
        return res;
    }
}


// if String:
// Recursion

public void permutation (String input) {
	int length = input.length();
	char[] in = input.toCharArray();
	boolean[] used = new boolean[length];
	StringBuffer word = new StringBuffer();
	permute(in, length, used, word);
}

public void permute(char[] in, int length, boolean[] used, StringBuffer word) {
	if(word.length() == length) {
		System.out.println(word.toString());
		return;
	}
	for(int i = 0; i < length; i++) {
		if(!used[i]) {
			word.append(in[i]);
			used[i] = true;
			permute(in, length, used, word);
			used[i] = false;
			word.deleteCharAt(word.length() - 1);
		}
	}
}
