class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length-1, k-1);
        return Arrays.copyOfRange(points, 0,k);
    }

    private void quickSelect(int [][] points, int left, int right, int kIdx){
        while(left<=right){
            int pivotIdx=partition(points,left, right);
            if(pivotIdx==kIdx)
            return;
            else if(pivotIdx>kIdx){
                right=pivotIdx-1;
            }else{
                left=pivotIdx+1;
            }
        }
    }

    private int partition(int [][] points, int left, int right){
        int pivotDist=distance(points[right]);
        int idx=left;

        for(int i=left;i<right;i++){
            if(distance(points[i])<=pivotDist){
                swap(points, idx, i);
                idx++;
            }
        }
        swap(points, idx, right);
        return idx;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}