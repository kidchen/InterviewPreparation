/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class Solution {
    public boolean canJump(int[] A) {
    // maxpath: record furthest distance from current position 
        int[] maxpath = new int[A.length];
        // consider [0]
        if(A.length>1 &&  A[0]==0) return false;
        maxpath[0]=A[0];
        for(int i=1; i<A.length; i++){
            maxpath[i]=Math.max(maxpath[i-1], A[i]+i);
            if(maxpath[i]<=i && i!= A.length-1){
                return false;
            }
        }
        return true;
    }
}

// Simple solution with DP(local&global), O(n) & O(1)

public class Solution {
    public boolean canJump(int[] A) {
        if(A.length == 0 || A == null) {
            return false;
        }
        int reach = 0;
        // !!! reach >= i, this means that if local can not reach to the next, break !!!
        for(int i = 0; i < A.length && reach >= i; i++) {
            reach = Math.max(reach, A[i] + i);
        }
        if(reach < A.length - 1) {
            return false;
        }
        return true;
    }
}
