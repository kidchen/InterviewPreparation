/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

// O(n), O(n) space

public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        // stack stores the index of s
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int max = 0;
        // keep tracking start position of valid parentheses
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    // invalid, move start position to the next
                    start = i + 1;
                } else {
                    stack.pop();
                    // after pop, if stack is empty, calculate the max = i - start + 1,
                    // !!! if stack is not empty, max = i - stack.peek() !!!
                    // because after pop and stack is still not empty, all chars after peek() must also be valid !
                    max = stack.isEmpty() ? Math.max(max, i - start + 1) : Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
