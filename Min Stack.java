/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

// O(1) operations, O(n) space costs

class MinStack {
    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> minStack = new ArrayList<Integer>();
    public void push(int x) {
        stack.add(x);
        if(minStack.isEmpty() || minStack.get(minStack.size() - 1) >= x) {
            minStack.add(x);
        }
        return;
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        int elem = stack.remove(stack.size() - 1);
        if(!minStack.isEmpty() && minStack.get(minStack.size() - 1) == elem) {
            minStack.remove(minStack.size() - 1);
        }
        return;
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return 0;
    }

    public int getMin() {
        if(!minStack.isEmpty()) {
            return minStack.get(minStack.size() - 1);
        }
        return 0;
    }
}


// Memory Limit Exceeded... why?
