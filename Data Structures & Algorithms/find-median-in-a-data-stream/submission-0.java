class MedianFinder {
    private PriorityQueue<Integer> small;//maxHeap;//small
    private PriorityQueue<Integer> large;//minHeap;//large
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        /**
        small should contain the smaller half
        large should contain the larger half

        small.size() should be equal to large.size()
        OR small can have 1 extra element
        */
        small.offer(num); 

        //remove biggest nu,ber from small put it in large
        large.offer(small.poll());

        if(large.size()>small.size()){
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size()>large.size()){
            return small.peek();
        }

        return (small.peek()+large.peek())/2.0;
    }
}
