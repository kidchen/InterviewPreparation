/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

// O(n^2) time, O(n^2) space

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0) {
            return result;
        }
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        for(int i = 1; i < numRows; i++) {
            ArrayList<Integer> item = new ArrayList<Integer>();
            item.add(1);
            for(int j = 1; j < i; j++) {
                item.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            item.add(1);
            result.add(item);
        }
        return result;
    }
}

/***** NOTE *****/
/* List is an interface, not a concrete class.
 * An interface is just a set of functions that a class can implement; 
 * it doesn't make any sense to instantiate an interface.
 * ArrayList is a concrete class that happens to implement this interface and all of the methods in it.
 */
