/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

// O(n), O(n) space

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return -1;
        }
        int result = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < tokens.length; i++) {
        // !!! have to use .equals rather than == !!!
        // !!! .equals: compare the two content(value) !!!
        // !!! ==: compare the two address !!!
        // eg: String a=new String("foo");
        //     String b=new String("foo");
        // if we use ==, then it returns false since they are not the same address, but .equals returns true
            if(tokens[i].equals("+")) {
                result = stack.pop() + stack.pop();
                stack.push(result);
            } else if(tokens[i].equals("-")) {
                result = -stack.pop() + stack.pop();
                stack.push(result);
            } else if(tokens[i].equals("*")) {
                result = stack.pop() * stack.pop();
                stack.push(result);
            } else if(tokens[i].equals("/")) {
                int divisor = stack.pop();
                result = stack.pop() / divisor;
                stack.push(result);
            } else {
                int digit = Integer.parseInt(tokens[i]);
                stack.push(digit);
            }
        }
        return stack.pop();
    }
}


// Notice: in this solution, we assume the input is always valid. 
// If not, we need to put the code into try-catch, or check whether the stack is empty before doing the pop operation.
