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
		for(int i : unsortedArray) {
			if(map.containsKey(i)) {
				int count = map.get(i);
				count++;
				map.put(i, count);
			} else {
				map.put(i, 1);
			}
		}
		int maxCount = 0;
		int element = 0;
		int start = 0;
		int[] result = new int[unsortedArray.length];
		while(!map.isEmpty()) {
			for(int i : map.keySet()) {
				if(map.get(i) > maxCount) {
					maxCount = map.get(i);
					element = i;
				}
			}
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
