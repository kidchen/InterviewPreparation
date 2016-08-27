import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length < 1) {
            return 0;
        }
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            if(i >= citations[i]) {
                return i;
            }
        }
        return citations.length;
    }
}