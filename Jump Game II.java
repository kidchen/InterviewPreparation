public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 0) return 0;
        int maxPath = 0, lastMaxPath = 0, step = 0;
        // !!! add condition " i <= maxPath" !!!
        for(int i =0; i < A.length && i <= maxPath; i++) {
            // current position is beyond the last jump: add step and jump to the next maxPath
            if(i > lastMaxPath) {
                step++;
                lastMaxPath = maxPath;
            }
            // calculate the maxPath in current position
            maxPath = Math.max(A[i] + i, maxPath);
        }
        // !!! REMEMBER TO "- 1" because we use index above to calculate path and 
        // now we need to -1 to check whether we can reach the last element
        if(maxPath < A.length - 1) return 0;
        return step;
    }
}
