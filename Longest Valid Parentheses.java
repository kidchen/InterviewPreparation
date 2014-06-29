public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null) return 0;
        // stack stores the index of s
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int start = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    // )((())
                    // stack top 1,2,3
                    // !!! if stack.isEmpty(): max = (max, i - start + 1) !!!
                    // !!! if not: max = i - stack.peek() !!!
                    max = stack.isEmpty() ? Math.max(max, i - start + 1) : Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
