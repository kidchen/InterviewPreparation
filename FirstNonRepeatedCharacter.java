import java.util.HashMap;


public class FirstNonRepeatedCharacter {	
	public static void main(String[] args) {
		char result = first("aabbccd");
		System.out.println(result);
	}
	public static char first(String word) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (int j = 0; j < word.length(); j++) {
			char c = word.charAt(j);
			if(map.get(c) == 1) {
				return c;
			}
		}
		return ' ';
	} 	
}
