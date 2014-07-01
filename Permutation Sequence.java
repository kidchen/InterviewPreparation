public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        // we need to use (n-1)!, so k--
        k--;
        // calculate (n-1)!
        int fact = 1;
        for(int i = 2; i < n; i++) {
            fact *= i;
        }
        // set chars
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            num.add(i);
        }
        // calculate each position
        int round = n - 1;
        while(round >= 0) {
            int index = k / fact;
            // !!!
            k %= fact;
            result.append(num.get(index));
            num.remove(index);
            if(round > 0) {
                fact /= round;
            }
            round--;
        }
        return result.toString();
    }
}
