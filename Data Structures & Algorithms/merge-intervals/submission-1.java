class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list=new ArrayList<>();

        if(intervals.length==1)
        return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int lastIntervalStart=intervals[0][0];
        int lastIntervalEnd=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];

            if(lastIntervalEnd>=currStart){
                lastIntervalEnd = Math.max(lastIntervalEnd, currEnd);
            }else{
                list.add(new int[] {lastIntervalStart, lastIntervalEnd});
                lastIntervalStart=currStart;
                lastIntervalEnd=currEnd;
            }
        }

        list.add(new int[] {lastIntervalStart, lastIntervalEnd});


        return list.toArray(new int[list.size()][]);
    }
}