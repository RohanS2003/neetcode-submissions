class Twitter {
    private int time;

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        time=0;
        followMap=new HashMap<>();
        tweetMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time));

        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap=new PriorityQueue<>(
            (a,b)->b.time-a.time
        );

        //add own tweets
        if(tweetMap.containsKey(userId)){
            for(Tweet tweet:tweetMap.get(userId)){
                maxHeap.offer(tweet);
            }
        }

        //add followee's tweets
        if(followMap.containsKey(userId)){
            for(int followeeId:followMap.get(userId)){
                if(tweetMap.containsKey(followeeId)){
                    for(Tweet tweet: tweetMap.get(followeeId)){
                        maxHeap.offer(tweet);
                    }
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        int i=0;
        while(!maxHeap.isEmpty() && i<10){
            res.add(maxHeap.poll().tweetId);
            i++;
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)
        return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }

    private class Tweet{
        int time;
        int tweetId;

        Tweet(int tweetId, int time){
            this.tweetId=tweetId;
            this.time=time;
        }
    }
}
