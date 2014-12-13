/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

// O(n) time/space

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers == null || numbers.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]);
                result[1] = i + 1;
                return result;
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return result;
    }
}


// if there are multiple solutions:
    public static void twoSum(int[] numbers, int target) {
        if(numbers.length == 0 || numbers == null) 
        	return;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])){
            	int a = map.get(target - numbers[i]) + 1;
            	int b = i + 1;
            	System.out.println(a + "," + b);
            } else {
            	map.put(numbers[i], i);
            }
        }
        return;
    }



// O(nlogn) solution with two indices, return the two numbers (all possible solutions):
	public static void twoSum(int[] numbers, int target) {
		if(numbers.length == 0) {
			return;
		}
		Arrays.sort(numbers);
		int start = 0;
		int end = numbers.length - 1;
		while(start < end) {
			int sum = numbers[start] + numbers[end];
			if(sum == target) {
				System.out.println(numbers[start] + "," + numbers[end]);
				start++;
				end--;
			} else if(sum < target) {
				start++;
			} else {
				end--;
			}
		}
		return;
	}
