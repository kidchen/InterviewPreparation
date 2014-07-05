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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        int i = 0;
        // [1,2],[3,4]... insert[2,4] ==> don't add '='
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        if(i < intervals.size()) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
        }
        result.add(newInterval);
        // [1,5] insert [0,1] ==> add '='
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            result.get(result.size() - 1).end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        while(i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }
}
