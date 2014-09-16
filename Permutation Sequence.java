/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

// O(n^2), O(1) space


public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
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
        // !!! round is the length of the number, zero-based !!!
        int round = n - 1;
        // !!! make k to zero-based !!!
        k--;
        while(round >= 0) {
            // every (n-1)! set, the current digit will be changed to the next in num
            int index = k / fact;
            // add current digit to result
            result.append(num.get(index));
            // !!! remove the element, for the next while loop !!!
            num.remove(index);
            // !!! find out the new kth in (n-1)! !!!
            k %= fact;
            // !!! if it is not the last element, recalculate (n-1)! by minus n by one !!!
            if(round > 0) {
                fact /= round;
            }
            round--;
        }
        return result.toString();
    }
}

// More related with math -- not easy to think in a short time, remember the pattern.
