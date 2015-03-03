
public class printWordsWithMaxWidth {
	
	public static void main(String[] args) {
		String s = "abc aa aaaa aaaa    aa aaa aaaa";
		print(s, 6);
		return;
	}
	
	public static void print(String s, int width) {
	    if(s == null || s.length() < width) {
	        System.out.println(s);
	    }
 
	    int end = 0;
	    while(end < s.length()) {
	        int lastPos = end;
	        int count = 0;	        
	        StringBuffer segment = new StringBuffer();
	        while(end < s.length()) {
	        	StringBuffer word = new StringBuffer();
	            while(end < s.length() && s.charAt(end) != ' ') {
	            	word.append(s.charAt(end));
	                end++;
	                count++;	                
	            }
	            if(count > width) {
	                end = lastPos;
	                break;
	            } else {
	                lastPos = end;
	                segment.append(word.toString());
	                segment.append(' ');
	                // if space counts
	                count++;
	                // remove duplicate spaces
	                while(end < s.length() && s.charAt(end) == ' ') {
	                    end++;
	                }
	            }
	        }
	        System.out.println(segment.toString().trim());
	        while(end < s.length() && s.charAt(end) == ' ') {
	        	end++;
	        }
	    }
	    
	    return;
	}
}
