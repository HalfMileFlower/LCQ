/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// Quick-sort Solution (fastest)
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }
        
        sortIntervals(intervals, 0, intervals.length - 1);
        // loop to find overlap
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
    
    private void sortIntervals(Interval[] intervals, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start;
        int right = end;
        int mid = intervals[left + (right - left) / 2].start;
        while (left <= right) {
            while (left <= right && intervals[left].start < mid) {
                left++;
            }
            
            while (left <= right && intervals[right].start > mid) {
                right--;
            }
            
            if (left <= right) {
                swap(intervals, left, right);
                left++;
                right--;
            }
        }
        sortIntervals(intervals, start, right);
        sortIntervals(intervals, left, end);
    }
    
    private void swap(Interval[] intervals, int left, int right) {
        Interval temp = intervals[left];
        intervals[left] = intervals[right];
        intervals[right] = temp;
    }
}  

// Notes: sort and compare
// TC: O(nlogn) SC: O(1)

// Comparator Solution 1 (slowest)
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        // loop to find overlap
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}  

// Comparator Solution 2
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                } else {
                    return a.start - b.start;
                }
            }
        });
        // loop to find overlap
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}  