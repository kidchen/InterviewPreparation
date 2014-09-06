package interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a string, design an algorithm in O(n) running time to 
 * find the character that appears more than half of the time in the string. 
 * If the character does not exist, output null.
 *   Input: abadacababaaaa
 *   Output: a
 *   Input: abcdeabbad
 *   Output: null
 *   
 * Written by: Chen Zhang
 * Email: cz294@cornell.edu
 */

/*
 * Thought: Since the algorithm should be run in O(n), we can only scan the string once.
 *          So we store the string in HashMap because the get/put method only cost O(1)
 */

public class Problem1 {

	public static void main(String[] args) {
		
		System.out.println("Press q to exit");
		Problem1 p1 = new Problem1();
		String s = "";		
		Scanner input = new Scanner(System.in);
		while (true) {
			// input the string
			System.out.print("Input:");
			s = input.nextLine();
			// quit if press "q"
			if(s.equals("q")){
				break;
			}
			// call the helper function
			char result = p1.helper(s);
			System.out.print("Output:");
			if (result == '\u0000')
				System.out.println("null");
			else
				System.out.println(result);
		}
	}

	public char helper(String s) {
		
		if(s.length()==1) return s.charAt(0);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char result = '\u0000';
		int max = 0;
		// store the string into HashMap
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			// for new char
			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				// for existed char
				int counter = map.get(temp) + 1;
				if(counter > s.length()/2){
					return temp;
				}
				map.put(temp, counter);
				if (counter > max) {
					result = temp;
					max = counter;
				}
			}
		}
		if (max > s.length() / 2)
			return result;
		else
			return '\u0000';
	}
}
