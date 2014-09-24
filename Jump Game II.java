public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        /*
        maxPath: so far, the max path(index) we can reach
        lastMaxPath: when current path(index) is bigger than lastmaxPath, step++, set the lastMaxPath as maxPath
        step: calculate how many steps should we take
        */
        int maxPath = 0, lastMaxPath = 0, step = 0;
        // !!! add condition " i <= maxPath", so that we can break when there is unreachable to the last !!!
        for(int i = 0; i < A.length && i <= maxPath; i++) {
            // current position is beyond the last jump: add step and jump to the next maxPath
            if(i > lastMaxPath) {
                step++;
                lastMaxPath = maxPath;
            }
            // calculate the maxPath in current position
            maxPath = Math.max(A[i] + i, maxPath);
        }
        // check the availability
        if(maxPath < A.length - 1) {
            return 0;
        }
        return step;
    }
}
