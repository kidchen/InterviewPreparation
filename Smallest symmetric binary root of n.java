/*
Write a function that will calculate the smallest symmetric binary root of a integer 
within O(sqrt(N)) complexity and O(1) space complexity.

The symmetric binary root of a of a given positive integer N is 
a positive integer A such that N = A * bit-rev(A). 
bit-rev(A) is an integer obtained by reversing the bits of A.
*/

//

public class Pixured2 {
	
	public static void main(String[] args) {
		int n = 286;
		System.out.println(Solution.solution(n));
	}
	
	static class Solution {
		
		/*
		 * Find the smallest symmetric binary root of n:
		 * Method 1: try each number from 0 to n, O(n) time
		 * Method 2: bit_rev(i) will always be an odd number!!!
		 */
		public static int solution(int n) {
			// shift until the number n is an odd number
			int shift = 0;
			while(n % 2 == 0) {
				shift++;
				n >>= 1;
			}
			for(int i = 0; i < Math.ceil(Math.sqrt(n)) + 1; i++) {
				if(i * bit_rev(i) == n) {
					// when we found the result, shift it back
					return i << shift;
				}
			}

			return -1;
		}
		
		/*
		 * reverse bit:
		 * Method 1: store the bits into a string and do reverse (cost extra space).
		 * Method 2: bit operation.
		 */
		private static int bit_rev(int n) {
	        int result = 0;
	        while (n != 0){
	        	result <<= 1;
	        	result |= (n & 1);
	        	n >>= 1;
	        }
			return result;
		}
	}

}
