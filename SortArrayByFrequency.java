import java.util.HashMap;

public class SortArrayByFrequency {
	
	public static void main(String[] args) {
		int[] unsortedArray = {2,12,3,2,4,2,3,3,3,12,5};
		int[] result = sortArray(unsortedArray);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
		
	static int[] sortArray(int[] unsortedArray) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// build the map: array elements as keys, their show times as values
		for(int i : unsortedArray) {
			if(map.containsKey(i)) {
				int count = map.get(i);
				count++;
				map.put(i, count);
			} else {
				map.put(i, 1);
			}
		}
		// maxCount: largest value in the map
		int maxCount = 0;
		// element: most frequently element in the array
		int element = 0;
		// new array index
		int start = 0;
		int[] result = new int[unsortedArray.length];
		while(!map.isEmpty()) {
			// find the most frequent element in the map
			for(int i : map.keySet()) {
				if(map.get(i) > maxCount) {
					maxCount = map.get(i);
					element = i;
				}
			}
			// start: result array's index
			// each time, add maxCount times elements
			// Noted that i = start
			for(int i = start; i < start + maxCount; i++) {
				result[i] = element;
			}
			start += maxCount;
			map.remove(element);
			maxCount = 0;
		}
		return result;
	}

}
