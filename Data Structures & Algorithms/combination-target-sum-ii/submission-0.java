class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, curr, result);

        return result;
    }

    private void backtrack(int[] nums, int target, int index,
                           List<Integer> curr,
                           List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(target<0 || index==nums.length){
            return;
        }

        //try each number as next num
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }

            if(nums[i]>target)
            break;

            curr.add(nums[i]);

            backtrack(nums, target-nums[i],i+1,curr,result);

            curr.remove(curr.size()-1);
        }
                    
    }
}
