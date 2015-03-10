/*
Given a sorted array A of distinct integers,  find a magic index if it exists in array A.  
A magic index in an array A[0…n-l] is defined as an index so that A[i] = i. 

The input should be a list of N integers, where N is less than or equal to 10,000. 
The absolute values of all intergers should be less than 1,000,000,000.
*/

// binary search(wrong answer?):

public static int getMagicIndex(int [] A) {
	if(A == null || A.length < 1) {
		return -1;
	}
	int start = 0;
	int end = A.length - 1;
	while(start < end) {
		int mid = start + (end - start) / 2;
		if(A[mid] == mid) {
			end = mid - 1;
		} else if(A[mid] > mid) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
	}
	return A[start] == start ? start : -1;
}

// brute force:

class Solution {
    public int getMagicIndex(int [] A) {
     
        if(A == null || A.length == 0) {
            return -1;
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i] == i) {
                return i;
            }
        }
        return -1;
 
        }
}
