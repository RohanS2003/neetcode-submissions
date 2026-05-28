class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums, 0, curr, result);

        return result;
    }

    private void backtrack(int[] nums, int index,
                           List<Integer> curr,
                           List<List<Integer>> result) {
        if(index==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        //take
        curr.add(nums[index]);
        backtrack(nums,index+1,curr, result);

        //undo
        curr.remove(curr.size()-1);

        //check dupli
        while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }

        //not take
        backtrack(nums, index+1, curr, result);
    }
}
