/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/


// simple Thought(two-pass):
// count how many element in each color and directly assign the elements into array..

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
public class Solution {
    public void sortColors(int[] A) {
        if(A.length<2) return;
        // red at the beginning and will keep the last red (excluded), blue at the end and will keep the first blue
        int red = 0, blue = A.length - 1, i = 0;
        while(i <= blue) {
            // if current color is red
            if(A[i] == 0) {
                // i is not red, swap current color with red(last excluded)
                if(i > red) {
                    swap(A, red, i);
                    red++;
                    
                }else{
                // i is red
                    red++;
                    i++;
                }
            }
            // if current color is blue
            else if(A[i] == 2) {
                if(i < blue){
                    swap(A, blue, i);
                    blue--;
                }else{
                // if i is blue, that means all elements after current one are blue
                    return;
                }
            }
            else{
            // current color is white, which means that it will remian in the middle, i++
                i++;
            }
        }
    }
    
    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
