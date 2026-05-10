class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;

            if(i>0 && nums[i]==nums[i-1])
            continue;

            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    left++;
                    right--;

                    // skip duplicate left values
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // skip duplicate right values
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
                
            }
        }
        return ans;
    }
}
