public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
	    map.put('V', 5);
	    map.put('X', 10);
	    map.put('L', 50);
	    map.put('C', 100);
	    map.put('D', 500);
	    map.put('M', 1000);
	    int result = map.get(s.charAt(s.length() - 1));
	    for (int i = s.length() - 2; i >= 0; i--) {
	        if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
	            result -= map.get(s.charAt(i));
	        } else {
	            result += map.get(s.charAt(i));
	        }
	    }
	    return result;
    }
}


/*** old version ***/

public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++){
            if (i>0 && r2i(s.charAt(i))>r2i(s.charAt(i-1))){
                result += r2i(s.charAt(i))-2*r2i(s.charAt(i-1));
            }
            else{
                result += r2i(s.charAt(i));
            }
        }
        return result;
    }
    
    int r2i(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
            default: return 0;
        }
    }
}
