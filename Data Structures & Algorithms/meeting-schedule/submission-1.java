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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        if(intervals==null || intervals.size()<=1){
            return true;
        }

        int lastEnd=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start<lastEnd){
                return false;
            }
            lastEnd=intervals.get(i).end;
        }
        return true;
    }
}
