class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longestSeq=0;
        for(int num:set){
            int currSeq=0;
            int currNum=num;
            if(!set.contains(currNum-1)){
                while(set.contains(currNum)){
                    currSeq++;
                    currNum++;
                }
                longestSeq=Math.max(currSeq, longestSeq);

            }
        }
        return longestSeq;
    }
}
