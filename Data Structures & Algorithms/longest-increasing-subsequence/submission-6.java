class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        temp.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int index = lowerBound(temp, nums[i]);
                temp.set(index, nums[i]);
            }
        }

        return temp.size();
    }

    private int lowerBound(List<Integer> temp, int target) {
        int left = 0;
        int right = temp.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (temp.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
