class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIdx=0;
        int currGas=0;

        int totalGas=0;
        int totalCost=0;

        for(int g:gas){
            totalGas+=g;
        }
        for(int c:cost){
            totalCost+=c;
        }

        if(totalGas<totalCost)
        return -1;

        for(int i=0;i<gas.length;i++){
            currGas+=gas[i]-cost[i];
            if(currGas<0){
                startIdx=i+1;
                currGas=0;
            }
        }
        return startIdx;
    }
}
