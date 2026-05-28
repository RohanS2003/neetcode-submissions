class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //maxHeap, to remove fartest point, as we want closer pt
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>(
            (a,b)->{
                int distA=a[0]*a[0]+a[1]*a[1];
                int distB=b[0]*b[0]+b[1]*b[1];

                return distB-distA; //maxHeap
            }
        );

        for(int [] pt:points){
            maxHeap.offer(pt);

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int [][] result=new int [k][2];

        for(int i=0;i<k;i++){
            result[i]=maxHeap.poll();
        }
        return result;

    }
}
