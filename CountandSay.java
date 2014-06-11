package leetcode;

public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}
	
    public static String countAndSay(int n) {
        if(n<=0) return null;
        // have to use a String to control the inner for loop
        String s = "1";
        int counter = 1;
        
        for(int i=0; i<n-1; i++){
        	// new in outer for loop (each nth),
        	// otherwise the result will be the sum of the previous
        	StringBuilder result = new StringBuilder();
            for(int j=0; j<s.length(); j++){
            	// check s.length()-1 for charAt(j+1)
                if(j<s.length()-1 && s.charAt(j)==s.charAt(j+1)){
                    counter++;
                }else{
                    result.append(counter).append(s.charAt(j));
                    counter = 1;
                }
            }
            // toString here so that we can use s to control the inner for loop next time
            s=result.toString();
        }
        return s;
    }
    
}
