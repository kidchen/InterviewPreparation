public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0 || numbers == null) return null;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])){
                result[0] = map.get(target - numbers[i]) + 1;    // !!! remember how to get
                result[1] = i + 1;
                return result;
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}


// not good to use two pointer method:
/*
        int[] result = new int[2];
        if(numbers.length == 0 || numbers == null) return null;
        Arrays.sort(numbers);
        int left = 0 , right = numbers.length - 1;
        System.out.println(numbers.length);
        while(left < right){
            if(numbers[left] + numbers[right] == target) {
                result[0] = left;
                result[1] = right;
                return result;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return null;
*/        
// not easy to get index since we sort the array at first
