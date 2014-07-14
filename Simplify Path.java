public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return "";
        }
        LinkedList<String> stack = new LinkedList<String>();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < path.length()) {
            int index = i;
            StringBuilder temp = new StringBuilder();
            // input path if current char is not "/"
            while(i < path.length() && path.charAt(i) != '/') {
                temp.append(path.charAt(i));
                i++;
            }
            // index != i means we DO while loop --> char != "/" --> path
            if(index != i) {
                // check the path: ".." pop; "." ignore; others push
                String tempstr = temp.toString();
                if(tempstr.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if(!tempstr.equals(".")) {
                    stack.push(tempstr);
                }
            }
            i++;
        }
        // can't directly use while(!stack.isEmpty()), since we need reverse order for each pop
        // and also need to add "/" between each of them
        if(!stack.isEmpty()) {
            String[] str = stack.toArray(new String[stack.size()]);
            // !!! have to use j, since i have already been defined above !!!
            for(int j = str.length - 1; j >= 0; j--) {
                result.append("/" + str[j]);
            }
        }
        if(result.length() == 0) {
            return "/";
        }
        return result.toString();
    }
}
