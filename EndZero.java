// put all zeros in a random int[] into its end

package interview;

public class EndZero {
	public static void main(String[] args) {
		int[] input = new int[2];
		input[0] = 0;
		input[1] = 1;
		int[] output = sortZero(input);
		System.out.println(output[0]);
		System.out.println(output[1]);
	}
	
	public static int[] sortZero(int[] input) {
	    if(input == null || input.length == 0) {
	        return input;
	    }
	    int start = 0;
	    int end = input.length - 1;
	    int counter = 0;
	    while(start <= end) {
	        if(input[start] == 0) {
	            while(start <= end && input[end] == 0) {
	                end--;
	                counter++;
	            }
	            
	            if(start <= end) {
	                int temp = input[end];
	                input[end] = input[start];
	                input[start] = temp;
	                end--;
	                counter++;
	            }
	        }
	        start++;
	    }
	    System.out.println("counter: " + counter);
	    return input;
	}
	    
}
