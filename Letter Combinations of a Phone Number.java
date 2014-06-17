public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuffer letter = new StringBuffer();
        helper(digits, result, 0, phone, letter);
        return result;
    }
    
    void helper(String digits, ArrayList<String> result, int index, String[] phone, StringBuffer letter) {
        if(index == digits.length()){
            result.add(letter.toString());
            return;
        }
        // !!! '0' is a char, do not use "0" !!!
        String indexLetter = phone[digits.charAt(index) - '0'];
        for(int i = 0; i < indexLetter.length(); i++){
            letter.append(indexLetter.charAt(i));
            helper(digits, result, index+1, phone, letter);
            letter.deleteCharAt(letter.length() - 1);
        }
    }
}
