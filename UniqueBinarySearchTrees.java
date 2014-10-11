/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

// DP: O(n^2), O(n) space
// count[2] = [0*1]+[1*0] = 2, count[3] = [0*2]+[1*1]+[2*0] = 5

// i: number of nodes in total
// j: number of nodes on the left of the root
// count[j] -- possible left subtree * count[i-j-1] -- possible right subtree (-1 means root)

public class Solution {
   public int numTrees(int n) {
      // count[i] store how many unique bst's are there by using i nodes
      int count[] = new int[n + 1];
      count[0] = 1;
      count[1] = 1;
      for (int i = 2; i <= n; i++) {
         for (int j = 0; j < i; j++) {
            // left subtree count[j] * right[i-j-1]
            count[i] += count[j] * count[i - j -1];
         }
      }
      return count[n];
    }
}
