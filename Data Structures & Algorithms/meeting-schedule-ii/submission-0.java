/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            // If earliest room is free, reuse it
            if (!minHeap.isEmpty() && interval.start >= minHeap.peek()) {
                minHeap.poll();
            }

            // Put current meeting's end time into heap
            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}
