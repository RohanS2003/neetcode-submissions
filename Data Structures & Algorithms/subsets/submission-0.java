class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        backtrack(nums, 0, curr, res);

        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        //include
        curr.add(nums[i]);
        backtrack(nums,i+1,curr,res);

        //undo choice
        curr.remove(curr.size()-1);

        //not include
        backtrack(nums,i+1,curr,res);
    }
}
