class Solution {
    private Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        int left=0;
        int right=nums.length-1;
        int target=nums.length-k;

        while(left<=right){
            int pivotIdx=partition(nums,left,right);
            if (pivotIdx == target) {
                return nums[pivotIdx];
            } else if (pivotIdx > target) {
                right = pivotIdx - 1;
            } else {
                left = pivotIdx + 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right){
        int randomIdx=left+random.nextInt(right-left+1);
        swap(nums,randomIdx,right);

        int pivot=nums[right];
        int idx=left;

        for(int i=left;i<right;i++){
            if(nums[i]<=pivot){
                swap(nums,idx,i);
                idx++;
            }
        }
        swap(nums, idx, right);
        return idx;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}