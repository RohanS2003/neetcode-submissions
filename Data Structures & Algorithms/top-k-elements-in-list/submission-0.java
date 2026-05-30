public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> [] freq=new ArrayList[nums.length+1];

        for(int i=0;i<freq.length;i++){
            freq[i]=new ArrayList<>();
        }

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int [] result=new int [k];
        int index=0;
        for(int i=freq.length-1;i>0 && index<k;i--){
            for(int n:freq[i]){
                result[index++]=n;
                if(index==k){
                    return result;
                }
            }
        }
        return result;
    }
}