class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while(!map.isEmpty()){
            int curr=map.firstKey();
            for(int i=curr;i<curr+groupSize;i++){
                if(!map.containsKey(i)){
                    return false;
                }

                map.put(i,map.get(i)-1);
                if(map.get(i)==0)
                map.remove(i);
            }
        }
        return true;
    }
}
