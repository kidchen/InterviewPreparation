/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

// O(n), O(n) space

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) {
            return 0;
        }
        // need 1 extra space for comparing the min
        int[] result = new int[triangle.size() + 1];
        // from the last row to the top
        for(int row = triangle.size() - 1; row >= 0; row--) {
        	// !!! traverse current row --> need to add "=" (row.length = row + 1, since row can be 0) !!!
            for(int col = 0; col <= row; col++) {
            	// find the min of the next row and add current element, then put into result
                result[col] = Math.min(result[col], result[col + 1]) + triangle.get(row).get(col);
            }
        }
        return result[0];
    }
}



/********* Yodle **********/


package interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Triangle
By starting at the top of the triangle and moving to adjacent numbers on the row below, 
the maximum total from top to bottom is 27.

        5
      9  6
    4   6  8
  0   7  1   5

I.e. 5 + 9 + 6 + 7 = 27.
 * 
 * @author Chen Zhang
 *
 */

public class Triangle {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		// replace the path with triangle.txt
		File text = new File("/Users/chenzhang/Downloads/triangle.txt");
		Scanner scan = new Scanner(text);
		// store the data into triangle
		while(scan.hasNextLine()){
			String s = scan.nextLine();
			String[] number = s.split(" ");
			ArrayList<Integer> line = new ArrayList<Integer>();
			for(int i=0; i<number.length; i++){
				line.add(Integer.parseInt(number[i]));
			}
			ArrayList<Integer> temp = new ArrayList<Integer>(line);
			triangle.add(temp);	
		}
		// System.out.println(triangle.get(3).get(3));
		int result = maxTotal(triangle);
		System.out.println("result: "+result);
	}
	
    public static int maxTotal(ArrayList<ArrayList<Integer>> triangle) {
        int row = triangle.size();
        int [] total = new int [row];
        // set the last row
        for(int i=0; i<triangle.get(row-1).size(); i++){
            total[i] = triangle.get(row-1).get(i);
        }
        // check from the bottom to the top
        for(int i=row-2; i>=0; i--){
            for(int j=0; j<triangle.get(i+1).size()-1; j++){
                total[j] = triangle.get(i).get(j) + Math.max(total[j], total[j+1]);
            }
        }
        return total[0];
    }

}
