class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;

        for(int i=0;i<piles.length;i++){
            right=Math.max(right, piles[i]);
        }
        int answer=right;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(canFinish(piles,mid,h)){
                //decrease search space
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return answer;
    }

    private boolean canFinish(int[] piles, int mid, int h){
        int totalHours=0;
        for(int i=0;i<piles.length;i++){
            double div = (double) piles[i] / mid;
            totalHours+=Math.ceil(div);
        }

        return totalHours<=h;
    }
}
