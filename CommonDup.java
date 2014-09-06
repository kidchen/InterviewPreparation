import java.util.ArrayList;
import java.util.Collections;


public class CommonDup {
	
	public static void main(String[] args) {
		ArrayList<Integer> sub1 = new ArrayList<Integer>();
		ArrayList<Integer> sub2 = new ArrayList<Integer>();
		sub1.add(1);
		sub1.add(2);
		sub1.add(2);
		sub1.add(3);
		sub1.add(3);
		sub2.add(1);
		sub2.add(3);
		sub2.add(3);
		sub2.add(4);
		sub2.add(4);
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		input.add(sub1);
		input.add(sub2);
		ArrayList<Integer> result = commonDuplicates(input);
		for(int i = 0; i < result.size(); i++) {
			System.out.println("result" + result.get(i));
		}
	}
	
	public static ArrayList<Integer> duplicates(ArrayList<Integer> input) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(input == null || input.size() < 2) {
			return result;
		}
		Collections.sort(input);
		for(int i = 1; i < input.size(); i++) {
			int cur = input.get(i);
			if(cur == input.get(i - 1) && (result.size() == 0 || cur != result.get(result.size() - 1))) {
				result.add(cur);
			}
		}
		return result;
	}


	public static ArrayList<Integer> commonDuplicates(ArrayList<ArrayList<Integer>> input) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(input == null || input.size() == 0) {
			return result;
		}
		ArrayList<Integer> subResult = new ArrayList<Integer>();
		for(int i = 0; i < input.size(); i++) {
			ArrayList<Integer> temp = duplicates(input.get(i));
			subResult.addAll(temp);
		}
		result = duplicates(subResult);
		return result;
	}

}
