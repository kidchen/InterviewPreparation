/*
Given an array of integers and a number k, 
the majority number is the number that occurs more than 1/k of the size of the array. Find it.

Note
There is only one majority number in the array.

Example
For [3,1,2,3,2,3,3,4,4,4] and k = 3, return 3

Challenge
O(n) time and O(k) extra space
*/

// O(n) time and O(k) extra space
// maintain a map<num, count>, if map doesn't contain cur num, check if map.size() == k 
// (if majority, each k diff nums should have more than one element)

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                // if there are k entries, check if there are any entries that
                // its value == 1, that is not satisfied with "more than 1/k"
                if(map.size() == k) {
                    Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
                    while(iter.hasNext()) {
                        Map.Entry<Integer, Integer> entry = iter.next();
                        if(entry.getValue() - 1 == 0) {
                            // can't use: map.remove(entry.getKey());
                            // above wrong code would lead the iter can't find its next !!!
                            iter.remove();
                        } else {
                            map.put(entry.getKey(), entry.getValue() - 1);
                        }
                    }
                } else {
                    map.put(num, 1);
                }
            }
        }
        // find the one that have highest value(count), that key should be the majority number
        int value = 0;
        int result = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > value) {
                value = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}

