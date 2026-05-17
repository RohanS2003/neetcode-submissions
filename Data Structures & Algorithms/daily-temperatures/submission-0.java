class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int n=temperatures.length;

        int [] result=new int[n];

        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int prevIndex=stack.pop();
                result[prevIndex]=i-prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
