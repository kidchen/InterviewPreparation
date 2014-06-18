// DFS

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        helper(s, result, list);
        return result;
    }
    
    void helper(String s, ArrayList<ArrayList<String>> result, ArrayList<String> list) {
        if(s.length() == 0){
            result.add(new ArrayList<String>(list));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
        // !!! substring, all lower case letters !!!
            String left = s.substring(0,i);
            if(isPalindrome(left)) {
                list.add(left);
                String right = s.substring(i);
                helper(right, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
