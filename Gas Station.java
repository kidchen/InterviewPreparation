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
