class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        List<int[]> ans=new ArrayList<>();

        for(int[] interval:intervals){
            if(!ans.isEmpty()){
                int[] last=ans.get(ans.size()-1);
                if(interval[0]<=last[1]){
                    last[1]=Math.max(last[1], interval[1]);
                }else{
                    ans.add(interval);
                }
            }
            else
            ans.add(interval);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
