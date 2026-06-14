class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;

        for(int i=0;i<=heights.length;i++){
            int currentHeight = (i == n) ? 0 : heights[i];
            //we go with extra imagonary bar with ht=0, to fkush out rem stack ele
            while(!stack.isEmpty() && heights[stack.peek()]>currentHeight){
                int height=heights[stack.pop()];

                int nextSmaller=i;
                int prevSmaller=stack.isEmpty()?-1:stack.peek();

                int width=nextSmaller-prevSmaller-1;
                int area=height*width;

                maxArea=Math.max(maxArea, area);
            }
            stack.push(i);
        }
    return maxArea;

    }
}
