/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

// O(n), O(1) space
// key point: if the sum of gas from start to current position is negative, any position between them is not suitable either !!!

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        int leftInTank = 0;
        int start = 0;
        int total = 0;
        for(int i = 0; i < gas.length; i++) {
            // how many gas left after moving to position i
            int remain = gas[i] - cost[i];
            leftInTank += remain;
            // if negative (cannot move to place i)
            if(leftInTank < 0) {
                leftInTank = 0;
                // this place is not good to start, move to the next
                start = i + 1;
            }
            // calculate the total gas remain
            total += remain;
        }
        return total >= 0 ? start : -1;
    }
}


/******** old solution *********/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // DP Problem
        int leftInTank = 0; // gas in the tank
        int start = 0; // start index, will be returned
        int total = 0; // count how many gas left in total from start to now
        for(int i = 0; i < gas.length; i++) {
            // remain: is there any left this turn i
            int remain = gas[i] - cost[i];
            // !!! >=  !!! if there still left gas or empty, continue
            if(leftInTank >= 0) {
                leftInTank += remain;
            } else {
                // start over from this point i
                leftInTank = remain;
                start = i;
            }
            total += remain;
        }
        return total >= 0 ? start : -1;
    }
}
