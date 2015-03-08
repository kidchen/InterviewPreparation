/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
*/

// O(32)

public class Solution {
    // you need treat n as an unsigned value
	public static int reverseBits(int n) {
	    int result = 0;
	    int count = 0;
	    while(count < 32) {
	        int mask = (1 << count) & n;
	        if(mask == 0) {
	            result <<= 1;
	        } else {
	            result = (result << 1) + 1;
	        }
	        count++;
	    }
	    return result;
    }
}
