public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3 || num == null) return result;
        // !!! don't forget to sort at first !!!
        Arrays.sort(num);
        // reverse for loop: be sure that this element is the biggest
        // i >= 2 !!!
        for(int i = num.length - 1; i > 1; i--) {
            // !!! not the last element but the same with the previous one, duplicate !!!
            if(i < num.length - 1 && num[i] == num[i + 1]) 
                continue;
            // i - 1 !!!
            ArrayList<ArrayList<Integer>> temp = twoSum(num, -num[i], i - 1);
            for(int j = 0; j < temp.size(); j++) {
                temp.get(j).add(num[i]);
            }
            result.addAll(temp);
        }
        return result;
    }
    
    ArrayList<ArrayList<Integer>> twoSum(int[] num, int target, int end) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 2 || num == null) return result;
        int start = 0;
        while(start < end) {
            int sum = num[start] + num[end];
            if(sum == target) {
                // every while loop, new a new set
                ArrayList<Integer> set = new ArrayList<Integer>();
                set.add(num[start]);
                set.add(num[end]);
                // add set to result in each loop
                result.add(set);
                start++;
                end--;
                // duplicate
                while(start < end && num[start] == num[start - 1]) 
                    start++;
                while(start < end && num[end] == num[end + 1]) 
                    end--;
            } else if(sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
