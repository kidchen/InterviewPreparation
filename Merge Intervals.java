/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

// O(nlogn + n) = O(n) time, O(1) space

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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            return result;
        }
        // create a new comparator
        Comparator<Interval> camp = new Comparator<Interval>() {
            // override without ";"
            @Override
            // !!! get familiar with this constructor !!!
            public int compare(Interval i1, Interval i2) {
                if(i1.start == i2.start) {
                    return i1.end - i2.end;
                } else {
                    return i1.start - i2.start;
                }
            }
        };
        Collections.sort(intervals, camp);
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            // if no intersect
            if(result.get(result.size() - 1).end < intervals.get(i).start) {
                result.add(intervals.get(i));
            } else {
                // dealing with end
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, intervals.get(i).end);
            }
        }
        return result;
    }
}
