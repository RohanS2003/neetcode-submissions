class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int [] prefix=new int [nums.length];
        // int [] suffix=new int [nums.length];

        // prefix[0]=1;
        // suffix[nums.length-1]=1;
        // for(int i=1;i<nums.length;i++){
        //     prefix[i]=nums[i-1]*prefix[i-1];
        // }

        // for(int i=nums.length-2;i>=0;i--){
        //     suffix[i]=nums[i+1]*suffix[i+1];
        // }

        int [] ans=new int [nums.length];
        // for(int i=0;i<nums.length;i++){
        //     ans[i]=prefix[i]*suffix[i];
        // }

        //optimal - keep only result array as prefix and for suffix use only one var

        ans[0]=1;
        for(int i=1;i<nums.length;i++){
            ans[i]=nums[i-1]*ans[i-1];
        }

        int postfix=1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]*=postfix;
            postfix*=nums[i];
        }

        return ans;
    }
}  
