/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/


// simple Thought(two-pass):
// count how many element in each color and directly assign the elements into array..
// O(2n), O(k) --> k = number of colors

// two-pass:

public class Solution {
    public void sortColors(int[] A) {
        int red = 0, white = 0, blue = 0;
        // count times (first pass)
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) red++;
            if(A[i] == 1) white++;
            if(A[i] == 2) blue++;
        }
        // create the result (second pass)
        for(int i = 0; i < A.length; i++) {
            if(red > 0){
                A[i] = 0;
                red--;
                continue;
            }
            if(white > 0){
                A[i] = 1;
                white--;
                continue;
            }
            A[i] = 2;
        }
    }
}


// one-pass:
// Only because this problem dealing with 3 colors
// O(n), O(1) space

public class Solution {
    public void sortColors(int[] A) {
        if(A == null || A.length == 0) {
            return;
        }
        int red = 0;
        int blue = A.length - 1;
        int i = 0;
        // !!! while is better than for to write, also PAY ATTENTION to i <= blue, rather than < A.length !!!
        // !!! equal: [1,0], if no "=", then the output would be [1,0] rather than [0,1] !!!
        while(i <= blue) {
            // !!! have to also check i>red / i<blue, to let the i move on !!!
            if(A[i] == 0 && i > red) {
                swap(A, i, red);
                red++;
            } else if(A[i] == 2 && i < blue) {
                swap(A, i, blue);
                blue--;
            } else {
                i++;
            }
        }
        return;
    }
    
    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
        return;
    }
}
