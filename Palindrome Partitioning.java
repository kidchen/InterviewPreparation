/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

// DFS: O(2^n), O(n) space

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) {
            return result;
        }
        List<String> item = new ArrayList<String>();
        helper(s, result, item);
        return result;
    }
    
    private void helper(String s, List<List<String>> result, List<String> item) {
        if(s.length() == 0) {
            result.add(new ArrayList<String>(item));
            return;
        }
        /*
        substring(include start, exclude end), substring(include start to the end)
        */
        for(int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if(isPalindrome(sub)) {
                item.add(sub);
                helper(s.substring(i), result, item);
                // DFS: don't forget to remove the last element after the recursion
                item.remove(item.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome (String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
