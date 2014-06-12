public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num.length < 3 || num == null) return Integer.MIN_VALUE;  // return MIN_VALUE !!!
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2] - target;
        for(int i = 0; i < num.length - 2; i++){
            int closest = twoSum(num, target - num[i], i + 1);
            if(Math.abs(closest) < Math.abs(result)){
                result = closest;
            }
        }
        // !!! don't forget to add target !!!
        return result + target;
    }
    
    int twoSum(int[] num, int target, int start){
        int end = num.length - 1;
        int result = num[start] + num[end] - target;
        while(start < end){
            if(result == 0) return 0;
            // new int to compare and get the smaller result !!!
            int closest = num[start] + num[end] -target;
            if(Math.abs(closest) < Math.abs(result)){
                result = closest;
            }
            if(num[start] + num[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return result;
    }
}
