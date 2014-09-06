package interview;

public class TrailZero {
	public static void main(String[] args) {
		int result = zero(29);
		System.out.println(result);
	}
	
	public static int zero (int number) {
		if(number < 0) {
			return -1;
		}
		int count = 0;
		for(int i = 5; number / i >= 1; i *= 5) {
			count += number / i;
		}
		return count;
	}
}
