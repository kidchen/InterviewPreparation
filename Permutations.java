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
