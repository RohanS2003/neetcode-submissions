class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(nums, target, 0, curr, result);

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

        //take
        curr.add(nums[index]);
        backtrack(nums, target-nums[index], index, curr, result);

        //undo
        curr.remove(curr.size() - 1);

        // skip
        backtrack(nums, target, index + 1, curr, result);
                    
    }
}
