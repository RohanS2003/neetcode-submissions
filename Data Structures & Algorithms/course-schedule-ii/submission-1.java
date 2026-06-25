class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];

        for(int[] pre:prerequisites){
            int preCourse=pre[1];
            int course=pre[0];

            adj.get(preCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int[] ans=new int[numCourses];
        int idx=0;

        while(!q.isEmpty()){
            int curr=q.poll();
            ans[idx++]=curr;

            for(int nextCourse:adj.get(curr)){
                indegree[nextCourse]--;

                if(indegree[nextCourse]==0){
                    q.offer(nextCourse);
                }
            }
        }

        if(idx==numCourses){
            return ans;
        }

        return new int[0];
    }
}
