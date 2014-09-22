/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

// O(n), O(n) space for the stack


public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return path;
        }
        LinkedList<String> stack = new LinkedList<String>();
        StringBuffer result = new StringBuffer();
        int i = 0;
        while(i < path.length()) {
            StringBuffer subpath = new StringBuffer();
            while(i < path.length() && path.charAt(i) != '/') {
                subpath.append(path.charAt(i));
                i++;
            }
            // if subpath is not only a '/'
            if(subpath.length() > 0) {
                String temp = subpath.toString();
                // !!! have to use .equals rather than == !!!
                // !!! can't directly check (equals && isEmpty()), since eg: /.. !!!
                if(temp.equals("..")) {
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else if(!temp.equals(".")) {
                    stack.push(temp);
                }
            }
            i++;
        }
        // !!!can't directly use while and later do reverse, since the path string itself should not be reversed !!!
        String[] reverse = new String[stack.size()];
        int j = 0;
        while(!stack.isEmpty()) {
            reverse[j] = stack.pop();
            j++;
        }
        for(j = reverse.length - 1; j >= 0; j--) {
            result.append("/");
            result.append(reverse[j]);
        }
        if(result.length() == 0) {
            return "/";
        }
        return result.toString();
    }
}
