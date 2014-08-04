public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        // fig: how many figures in x
        int fig = 1;
        while(x/fig>=10){
            fig*=10;
        }
        while(x!=0){
            int left = x/fig;
            int right = x%10;
            if(left!=right) return false;
            // 12321
            // 232
            // 3
            x= (x%fig)/10;
            fig/=100;
        }
        return true;
    }
}


// general solution:
public boolean isPalindrome(int x) {
	if(x < 0) {
		return false;
	}
	String str = new String();
	str = String.valueOf(x);
	int left = 0, right = str.length() - 1;
	while(left <= right) {
		if(str.charAt(left) != str.charAt(right)) {
			return false;
		}
		left++;
		right--;
	}
	return true;
}
