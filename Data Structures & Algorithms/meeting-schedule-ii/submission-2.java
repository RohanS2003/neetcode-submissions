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
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map=new TreeMap<>();

        for(int i=0;i<intervals.size();i++){
            int start=intervals.get(i).start;
            int end=intervals.get(i).end;

            map.put(start, map.getOrDefault(start,0)+1);
            map.put(end, map.getOrDefault(end,0)-1);
        }

        int maxRooms=0;
        int rooms=0;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            rooms+=entry.getValue();
            maxRooms=Math.max(rooms, maxRooms);
        }

        return maxRooms;
    }
}
