/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

 // PriorityQueue Solution
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        
        minHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval head = minHeap.poll();
            if (intervals[i].start < head.end) {
                minHeap.offer(intervals[i]);
            } else {
                head.end = intervals[i].end;
            }
            minHeap.offer(head);
        }
        return minHeap.size();
    }
}

// Notes: use priority queue to store smallest end
// pay attention to the grammar of priority queue
/* 
 *  PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
 *     public int compare(Interval i1, Interval i2) {
 *          return i1.end - i2.end;
 *      }
 *  });
 */
// TC: O(nlogn)(PQ offer O(logn), poll O(1))  SC: O(n)
