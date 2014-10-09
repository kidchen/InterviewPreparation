/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

// O(n^2), O(n) space
// use a hashmap<double slope, integer numberOfPointsInALine>, double slope = (p2.y - p1.y) / (p2.x - p1.x)
// two loops, outer loop traverse all points, inner loop traverse all left points from the outer loop.


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        int max = 1;
        for(int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            // !!! if all points are overlap !!!
            map.put((double)Integer.MIN_VALUE, 1);
            int dup = 0;
            for(int j = i + 1; j < points.length; j++) {
                // if this point is overlap the previous one:
                if(points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }
                // !!! 0/0 = 0, 0/-0 = -0, so we need to add 0.0 after calculate !!!
                // !!! also, don't forget to parse the int to double in every calculate part !!!
                double slope = points[j].x == points[i].x ? (double)Integer.MAX_VALUE : 
                0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                if(map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 2);
                }
            }
            for(int value : map.values()) {
                if(value + dup > max) {
                    max = value + dup;
                }
            }
        }
        return max;
    }
}
