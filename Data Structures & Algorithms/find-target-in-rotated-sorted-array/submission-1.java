class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        
        //one pass
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
            return mid;

            //left sorted
            if(nums[l]<=nums[mid]){
                //check if target in left half else go to right
                if(target>=nums[l] && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                //right sorted check and also check in right half if not left
                if(target<=nums[r] && target>nums[mid]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
