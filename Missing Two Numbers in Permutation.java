/*
If exactly two numbers are missing in a permutation of integers from 1 to n, how would you find them efficiently?

The input should be a list of exactly (n - 2) numbers, where n > 2. 
And the numbers should be a permutation of integers from 1 to n except the two missing distinct numbers, 
where n should be less than or equal to 1,000,000.
*/

// Math: calculate a+b and a^2+b^2

class Solution {
    int[] missing2Numbers(int [] a) {
        int[] result = {1, 2};
        if(a == null || a.length == 0) {
            return result;
        }
        int sum = 0;
        int sum2 = 0;
        for(int i = 0; i < a.length; i++) {
            sum += (i + 1 - a[i]);
            sum2 += ((i + 1) * (i + 1) - (a[i] * a[i]));
        }
        sum += (a.length + 1 + a.length + 2);
        sum2 += ((a.length + 1) * (a.length + 1) + (a.length + 2) * (a.length + 2)); 
        for(int i = 1; i <= a.length + 2; i++) {
            if(i * i + (sum - i) * (sum - i) == sum2) {
                result[0] = i;
                result[1] = sum - i;
                break;
            }
        }
        return result;
        }
}
