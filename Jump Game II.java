/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

// DP(local & global) : O(n), O(1)

public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        // lastPath: last step within maxPath, if i>lastPath, 
        // that means we found a step within maxPath which can reach further, so we step++
        int maxPath = 0, lastPath = 0, step = 0;
        // !!! add condition " i <= maxPath", so that we can break when there is unreachable to the last !!!
        for(int i = 0; i < A.length && i <= maxPath; i++) {
            if(i > lastPath) {
                step++;
                lastPath = maxPath;
            }
            maxPath = Math.max(A[i] + i, maxPath);
        }
        // check the availability
        if(maxPath < A.length - 1) {
            return 0;
        }
        return step;
    }
}
