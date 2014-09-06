import java.util.HashMap;


public class RemoveDuplicatesInString {	
	public static void main(String[] args) {
		String result = removeDuplicates("abcdeeff");
		System.out.println(result);
	}
	private static String removeDuplicates(String s) {
		char[] charArray = s.toCharArray();
		int inputIndex = 0, resiudalIndex = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		while (inputIndex < charArray.length) {
			if (!map.containsKey(String.valueOf(charArray[inputIndex]))) {
				map.put(String.valueOf(charArray[inputIndex]), 1);
				charArray[resiudalIndex] = charArray[inputIndex];
				resiudalIndex++;
			}
			inputIndex++;
		}
		for(int i = resiudalIndex; i < charArray.length; i++) {
			charArray[i] = '\0';
		}
		return String.valueOf(charArray);
	}	
}
