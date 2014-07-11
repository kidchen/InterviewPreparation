public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < tokens.length; i++) {
        
        // !!! have to use .equals rather than == !!!
        // !!! .equals: compare the two content(value) !!!
        // !!! ==: compare the two address !!!
        // eg: String a=new String("foo");
        //     String b=new String("foo");
        // if we use ==, then it returns false since they are not the same address, but .equals returns true
        
            if(tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if(tokens[i].equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if(tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if(tokens[i].equals("/")) {
                int num = stack.pop();
                stack.push(stack.pop() / num);
            } else {
                int value = Integer.parseInt(tokens[i]);
                stack.push(value);
            }
        }
        return stack.pop();
    }
}
