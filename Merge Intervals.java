/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return intervals;
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start == i2.start) {
                    return i1.end - i2.end;
                } else return i1.start - i2.start;
            }
        // !!! add ; after implement comparator
        };
        Collections.sort(intervals, comp);
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            // [x,9] < [x,10]
            if(result.get(result.size() - 1).end < intervals.get(i).start) {
                result.add(intervals.get(i));
            } else {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, intervals.get(i).end);
            }
        }
        return result;
    }
}
