public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4) return result;
        Arrays.sort(num);
        for(int i = num.length - 1; i >= 3; i--){
            if(i < num.length - 1 && num[i] == num[i+1]) continue;
            ArrayList<ArrayList<Integer>> set = threeSum(num, i - 1, target - num[i]);
            for(int j = 0; j < set.size(); j++){
                set.get(j).add(num[i]);
            }
            result.addAll(set);
        }
        return result;
    }
    
    ArrayList<ArrayList<Integer>> threeSum(int[] num, int end, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // no need to check null and sort num[]
        for(int i = end; i >= 2; i--){
            if(i < end && num[i] == num[i+1]) continue;
            ArrayList<ArrayList<Integer>> set = twoSum(num, i - 1, target - num[i]);
            for(int j = 0; j < set.size(); j++){
                set.get(j).add(num[i]);
            }
            result.addAll(set);
        }
        return result;        
    }
    
    ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int start = 0;
        while(start < end){
            if(num[start] + num[end] == target){
                ArrayList<Integer> set = new ArrayList<Integer>();
                set.add(num[start]);
                set.add(num[end]);
                result.add(set);
                start++;
                end--;
                // !!! duplicate: not continue !!!
                while(start < end && num[start] == num[start - 1]) start++;
                while(start < end && num[end] == num[end + 1]) end--;
            } else if(num[start] + num[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
