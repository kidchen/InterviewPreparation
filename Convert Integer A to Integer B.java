/*
Determine the number of bits required to convert integer A to integer B 

Example
Given n = 31, m = 14,return 2

(31)10=(11111)2

(14)10=(01110)2
*/

// O(1) time and space cost

    public static int bitSwapRequired(int a, int b) {
        // write your code here
        if(a == b) {
            return 0;
        }
        int diff = a ^ b;
        int mask = 1;
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((diff & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
