class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.minHeap=new PriorityQueue<>();

        for(int n:nums){
            add(n);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if(minHeap.size()>k){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
