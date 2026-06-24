class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int maxWater=0;
        int water=0;

        while(left<right){
            if(heights[left]<heights[right]){
                water=(right-left)*heights[left];
                left++;
            }else{
                water=(right-left)*heights[right];
                right--;
            }
            maxWater=Math.max(water, maxWater);
        }
        return maxWater;
    }
}
