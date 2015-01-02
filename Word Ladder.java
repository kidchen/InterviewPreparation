/*
Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

// O(min(26^L, size(dict)), O(min(26^L, size(dict)) space. L: length of the word

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || start.length() == 0 || end == null || end.length() == 0 || start.length() != end.length()) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(start);
        // !!! have to remove !!!
        dict.remove(start);
        int result = 1;
        while(!queue.isEmpty()) {
            // !!! each time only change one char, we need to check all intermediate words in queue for THIS while loop !!!
            // !!! have to use int outside for loop !!!
            int poss = queue.size();
            for(int i = 0; i < poss; i++) {
                String cur = queue.poll();
                for(int j = 0; j < cur.length(); j++) {
                    char[] curChar = cur.toCharArray();
                    // !!! for loop can use char as parameter !!!
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(cur.charAt(j) == c) {
                            continue;
                        }
                        curChar[j] = c;
                        String temp = new String(curChar);
                        // !!! can't use "==", have to use .equals to check whether their values are equal. !!!
                        if(temp.equals(end)) {
                            return result + 1;
                        }
                        if(dict.contains(temp)) {
                            queue.offer(temp);
                            // don't forget to remove
                            dict.remove(temp);
                        }
                    }
                }
            }
            // !!! after loop all elements in queue, add 1 !!!
            result++;
        }
        return 0;
    }
}


/********* old version **********/

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || start.length() == 0 || end == null || end.length() == 0 || start.length() != end.length()) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.add(start);
        visited.add(start);
        int level = 1;
        int queueNum = 1;
        int curNum = 0;
        while(!queue.isEmpty()) {
            String str = queue.poll();
            queueNum--;
            for(int i = 0; i < str.length(); i++) {
                // !!! have to put here !!!
                char[] cur = str.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    cur[i] = c;
                    String temp = new String(cur);
                    if(temp.equals(end)) {
                        return level + 1;
                    }
                    if(dict.contains(temp) && !visited.contains(temp)) {
                        queue.add(temp);
                        visited.add(temp);
                        curNum++;
                    }
                }
            }
            // !!! 
            if(queueNum == 0) {
                queueNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return 0;
    }
}
