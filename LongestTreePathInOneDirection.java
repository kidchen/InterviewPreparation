import java.util.LinkedList;

public class LongestTreePathInOneDirection {
	
	// you can also use imports, for example:
	// import java.util.*;

	// you can use System.out.println for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	class Tree{
		int x;
		Tree l;
		Tree r;
	}
	
	class Solution {
	    public int solution(Tree T) {
	        // write your code in Java SE 8
	        if(T == null) {
	            return -1;
	        }
	        if(T.l == null && T.r == null) {
	            return 0;
	        }
	        int maxLength = 0;
	        LinkedList<Tree> stack = new LinkedList<Tree>();
	        T.x = 0;
	        stack.add(T);
	        while (!stack.isEmpty())
	        {
	            Tree currNode = stack.pop();
	            int reminder = currNode.x % 100000;
	            if (currNode.l != null)
	            {
	                currNode.l.x = 1 + reminder;
	                maxLength = Math.max(maxLength, currNode.l.x);
	                stack.push(currNode.l);
	            }
	            if (currNode.r != null)
	            {
	                currNode.r.x = 100000 + (currNode.x - reminder);
	                maxLength = Math.max(maxLength, currNode.r.x / 100000);
	                stack.push(currNode.r);
	            }
	        }
	        return maxLength;
	    }
	}


}
