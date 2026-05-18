class Solution {
    public int maxProfit(int[] prices) {
        int left=0;
        int right=1;

        int maxProfit=0;

        while(right<prices.length){
            int profit=prices[right]-prices[left];
            if(profit<0){
                left=right;
            }else{
                maxProfit = Math.max(maxProfit, profit);
            }
            right++;
        }
        return maxProfit;
    }
}
