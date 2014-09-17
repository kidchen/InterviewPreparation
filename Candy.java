/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

// O(n), O(n) space
// two passes, similar with "trapping rain water" problem

public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] num = new int[ratings.length];
        // first, from left to right:
        // if cur rate is bigger than its left, put left value + 1, else set 1
        num[0] = 1;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            } else {
                num[i] = 1;
            }
        }
        // since the most right one is only related with its left, which has been dealed with in the last for loop, we put the value to result as initial
        int result = num[ratings.length - 1];
        // from right to left, if cur rate is bigger than its right, set cur = right + 1
        // compare cur with num[i], choose the bigger one as final value
        for(int i = ratings.length - 2; i >= 0; i--) {
            int cur = 1;
            if(ratings[i] > ratings[i + 1]) {
                cur += num[i + 1];
            }
            num[i] = Math.max(cur, num[i]);
            result += num[i];
        }
        return result;
    }
}
