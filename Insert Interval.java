/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/

// O(n) time/space
// if we store as linked list, we can do it in-place so that the space cost O(1)

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        int i = 0;
        // add all before newInterval
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        // change newInterval.start if: [4,5] insert into [1,2][3,6] --> [4,5]->[3,5]
        if(i < intervals.size()) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        }
        // add newInterval
        result.add(newInterval);
        // change newInterval.end
        // !!! attention to "=" !!!
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            result.get(result.size() - 1).end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        // add all after newInterval
        while(i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }
}


// follow up:
// If when insert, it should do merge, we return without insert.

/*
Do it by binary search: We do insert if no need to merge. Otherwise we do binary search and reduce the time cost to O(logn).
*/
