/*

*/

public class BrokenKeyBoard {
	public static void main(String[] args) {
		String actual = "164";
		String expected = "186848";
		System.out.println(IsAMatch(actual, expected));
	}
	private static boolean IsAMatch(String actual, String expected){
		char faultyKey = ' ';
		int i = 0, j = 0;
		for(; i < expected.length() && j < actual.length(); i++) {
			if(actual.charAt(j) != expected.charAt(i)) {
				if(faultyKey != ' ') {
					if(faultyKey != expected.charAt(i))
						return false;
				} else {
					faultyKey = expected.charAt(i);
				}
			} else {
				j++;
			}
		}
		while(i<expected.length()&& expected.charAt(i)==faultyKey ) {
			i++;	
		}
		return (i == expected.length() && j == actual.length())? true : false;
	}
}
