/*
Given a chessboard with 0 and 1 represents available positions(0) and unavailable(1). 
Find a way to get to the right bottom from top left. The steps are ruled with 'L' shape:
s---0
|\  |
0---0
|  \|
0---e
*/


import java.util.ArrayList;

public class Pixured {
	
	public static void main(String[] args) {
		int[][] chessboard = {{0,0,0},{0,0,1},{1,0,0},{0,0,0}};
		System.out.println(Solution.solution(chessboard));
	}
	
	static class Solution {
		public static int solution(int[][] A) {
			if(A == null || A.length == 0 || A[0].length == 0) {
				return -1;
			}
			
			boolean[][] used = new boolean[A.length][A[0].length];
			ArrayList<Integer> result = new ArrayList<Integer>();
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(0);
			if(findPath(A, used, result, path, 0, 0)) {
				return result.get(0);
			}
			return -1;
		}
		
		private static boolean findPath(int[][] A, boolean[][] used, ArrayList<Integer> result, ArrayList<Integer> path, int row, int col) {
			
			if(row == A.length - 1 && col == A[0].length - 1) {
				result.add(path.get(0));
				return true;
			}
			if(row < 0 || col < 0 || row >= A.length || col >= A[0].length || used[row][col] || A[row][col] == 1) {
		            return false;
		    }
	        used[row][col] = true;
	        path.set(0, path.get(0) + 1);
	        boolean find = 	        
	        		findPath(A, used, result, path, row - 2, col - 1) ||
	        		findPath(A, used, result, path, row - 1, col - 2) ||
	        		findPath(A, used, result, path, row + 1, col - 2) ||
	        		findPath(A, used, result, path, row + 2, col - 1) ||
	        		findPath(A, used, result, path, row + 2, col + 1) ||
	        		findPath(A, used, result, path, row + 1, col + 2) ||
	        		findPath(A, used, result, path, row - 1, col + 2) ||
	        		findPath(A, used, result, path, row - 2, col + 1);
	        used[row][col] = false;
	        path.set(0, path.get(0) - 1);
	        return find;
		}
	}
}
