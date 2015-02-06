/*
Given a list of segments, find a line that can intersect most of the segments in verticle way.
*/

/* Thought:
Store the start points and end points of the segments in a hashmap.
If it is a start point, the value of this point is 1, if it is an end point, the value is -1.
Then we sort the map by its key(points), sum the value of them.
When we find the biggest value, its corresponding key is the line.
*/

// O(n) scan, O(n)+O(n) to do the map, O(nlogn)+O(n) to do the sort, O(n) to find the line --> O(nlogn) time, O(n) space
// We can also use a treeMap to avoid the sort part, but the complexity is the same, since the performance of TreeMap is O(logn)

package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Interval {
	int start;
	int end;
	Interval() {
		start = 0;
		end = 0;
	}
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class intersectSeg {
	
	public static void main(String[] args) {
		ArrayList<Interval> seg = new ArrayList<Interval>();
		Interval i1 = new Interval(0,3);
		Interval i2 = new Interval(0,5);
		Interval i3 = new Interval(2,3);
		Interval i4 = new Interval(2,4);
		Interval i5 = new Interval(1,5);
		seg.add(i1);
		seg.add(i5);
		seg.add(i3);
		seg.add(i2);
		seg.add(i4);
		System.out.println(find(seg));
	}
	
	public static int find(ArrayList<Interval> seg) {
		if(seg == null || seg.size() == 0) {
			return 0;
		}
		
		// build up the map<two positons of the segments, <start/end>>
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(Interval i : seg) {
			if(!map.containsKey(i.start)) {
				ArrayList<Integer> array = new ArrayList<Integer>();
				array.add(1);
				map.put(i.start, array);
			} else {				
				map.get(i.start).add(1);
			} 
			if(!map.containsKey(i.end)) {
				ArrayList<Integer> array = new ArrayList<Integer>();
				array.add(-1);
				map.put(i.end, array);				
			} else {
				map.get(i.end).add(-1);
			}
		}
		
		// Sort the map by its key
		List<Map.Entry<Integer, ArrayList<Integer>>> list = new ArrayList<Map.Entry<Integer,ArrayList<Integer>>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, ArrayList<Integer>>>() {
			public int compare(Entry<Integer, ArrayList<Integer>> o1,
                Entry<Integer, ArrayList<Integer>> o2) {
				return o1.getKey() - o2.getKey();
			}
		});
		
		int intersect = 0;
		int max = 0;
		int line = 0;
		
		// scan the list and calculate the value sum, 
		// find the biggest sum, its key is the line we find
		for(Map.Entry<Integer, ArrayList<Integer>> entry : list) {
			for(int i = 0; i < entry.getValue().size(); i++) {
				intersect += entry.getValue().get(i);
				// assume we only need to return one valid result
				if(intersect > max) {
					max = intersect;
					line = entry.getKey();
				}
			}
		}
		
		return line;
	}

}
