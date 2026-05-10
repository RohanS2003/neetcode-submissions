class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;

        // Arrays.sort(nums);

        // int longest=1;
        // int currStreak=1;

        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]==nums[i-1]){
        //         //skip duplicate
        //         continue;
        //     }

        //     if(nums[i]==nums[i-1]+1){
        //         currStreak+=1;
        //     }else{
        //         currStreak=1;
        //     }

        //     longest=Math.max(longest, currStreak);
        // }
        // return longest;

        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int longest=0;

        for(int num: set){
            int streak=1;
            int currNumber=num;
            if(set.contains(currNumber-1))
            continue;

            while(set.contains(currNumber+1)){
                streak++;
                currNumber++;
            }

            longest=Math.max(longest, streak);
        }

        return longest;
    }
}
