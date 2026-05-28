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

        curr.add(nums[index]);

        // index + 1 because each element can be used only once
        backtrack(nums, target - nums[index], index + 1, curr, result);

        // undo
        curr.remove(curr.size() - 1);

        // skip all duplicates of nums[index]
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

         // skip nums[index]
        backtrack(nums, target, index + 1, curr, result);
                    
    }
}
