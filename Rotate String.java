/*
Given a string and an offset, rotate string by offset. (rotate from left to right)

Example
Given "abcdefg"

for offset=0, return "abcdefg"
for offset=1, return "gabcdef"
for offset=2, return "fgabcde"
for offset=3, return "efgabcd"
...
*/

// O(n) time with O(1) space cost

public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        if(A == null) {
            return null;
        }
        if(offset == 0 || A.length == 0) {
            return A;
        }
        if(offset > A.length) {
            offset %= A.length;
        }
        reverse(A, 0, A.length - offset - 1);
        reverse(A, A.length - offset, A.length - 1);
        reverse(A, 0, A.length - 1);
        return A;
    }
    
    private void reverse(char[] A, int start, int end) {
        if(A == null || A.length < 2) {
            return;
        }
        while(start < end) {
            char temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
        return;
    }
};
