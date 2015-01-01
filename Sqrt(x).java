/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

// O(logx), O(1) space cost

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x < 0) {
            return -1;
        }
        // !!! left from 1 !!!
        int left = 1;
        int right = x;
        // !!! left <= right !!!
        while(left <= right) {
            int mid = (left + right) / 2;
            // !!! can't use mid*mid, think about the boundry conditions !!!
            if(mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if(mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}


/******* old version *******/
public class Solution {
    public int sqrt(int x) {
        if(x < 0) {
            return -1;
        }
        if(x == 0) {
            return 0;
        }
        // !!! have to start from 1, because later the result will be as divisor(can't be 0), (left+right)/2 can't be 0 !!!
        int left = 1;
        // !!! remember +1, eg: input 1 !!!
        int right = x / 2 + 1;
        int result = 0;
        while(left <= x) {
            result = (left + right) / 2;
            // !!! can't use result*result<=x, if input is MAX_VALUE !!!
            if(result <= x / result && (result + 1) > x / (result + 1)) {
                return result;
            } else if(result > x / result) {
                right = result - 1;
            } else {
                left = result + 1;
            }
        }
        return result;
    }
}
