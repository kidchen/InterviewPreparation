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
