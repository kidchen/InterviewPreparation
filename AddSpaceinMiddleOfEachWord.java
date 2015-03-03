/*
input: "A person can't walk in this street"
output: "A per son ca n't wa lk in th is str eet"
*/

public class AddSpace {
	public static void main(String[] args) {
		String input = "A person can't walk in this street";
		System.out.println(addSpace(input));
	}	
	private static String addSpace(String input) {
		StringBuffer result = new StringBuffer();
		int i = 0;
		while(i < input.length()){
			StringBuffer word = new StringBuffer();
			int count = 0;
			while(i < input.length() && input.charAt(i) != ' ') {
				char cur = input.charAt(i);
				word.append(cur);
				if(cur >= 'a' && cur <= 'z' || cur >= 'A' && cur <= 'Z') {
					count++;
				}
				i++;
			}
			if(count % 2 == 0 && count >= 4) {
				word.insert(count/2, ' ');
			}
			result.append(word);
			result.append(' ');
			while(i < input.length() && input.charAt(i) == ' ') {
				i++;
			}
		}
		return result.toString().trim();
	}
}
