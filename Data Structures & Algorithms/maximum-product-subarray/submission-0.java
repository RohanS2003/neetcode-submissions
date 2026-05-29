class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(prefix==0){
                prefix=1;
            }

            if(suffix==1){
                suffix=1;
            }

            prefix=prefix*nums[i];
            suffix=suffix*nums[n-1-i];

            maxProduct=Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }
}
