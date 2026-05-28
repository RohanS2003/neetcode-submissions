class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] count=new int [26];

        for(char task:tasks){
            count[task-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int freq : count) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int freq=maxHeap.poll();
                freq--;

                if(freq>0){
                    q.offer(new int[] {freq, time+n});
                }
            }

            if(!q.isEmpty()){
                if(q.peek()[1]==time){
                    maxHeap.offer(q.poll()[0]);
                }
            }
        }
        return time;
    }
}
