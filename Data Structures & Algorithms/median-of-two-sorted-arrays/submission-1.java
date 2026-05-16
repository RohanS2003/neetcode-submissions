class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
         * Always binary search on the smaller array.
         *
         * Why?
         * We choose cut1 in nums1.
         * Then cut2 is automatically:
         *
         *      cut2 = half - cut1
         *
         * If nums1 is bigger, cut2 can become negative or out of range.
         * Keeping nums1 smaller keeps cut2 safe.
         */
        if(nums1.length>nums2.length)
        return findMedianSortedArrays(nums2, nums1);

        int m=nums1.length;
        int n=nums2.length;

        int total=m+n;

        /*
         * We want left side to contain half of total elements.
         *
         * For odd total:
         * merged = [1, 2, 3, 4, 5]
         *
         * left side should be:
         * [1, 2, 3]
         *
         * So median is max(left side).
         *
         * That is why we use:
         * (total + 1) / 2
         *
         * The +1 puts the extra middle element on the left side.
         */

         int half = (total + 1) / 2;

        /*
         * We binary search on how many elements to take
         * from nums1 into the left side.
         *
         * cut1 can be from 0 to m.
         *
         * cut1 = 0 means:
         * nums1: [] | [all elements]
         *
         * cut1 = m means:
         * nums1: [all elements] | []
         */

         int left=0;
         int right=m;

         while(left<=right){
            /*
             * cut1 = number of elements taken from nums1
             * into the combined left side.
             */
            int cut1=left+(right-left)/2;
            /*
             * Total left side size must be half.
             *
             * If cut1 elements come from nums1,
             * then remaining elements must come from nums2.
             */
             int cut2=half-cut1;

             /*
             * We only care about the border values:
             *
             * nums1: ... left1 | right1 ...
             * nums2: ... left2 | right2 ...
             *
             * left1  = biggest value on left side of nums1
             * right1 = smallest value on right side of nums1
             *
             * left2  = biggest value on left side of nums2
             * right2 = smallest value on right side of nums2
             */

            /*
             * If cut1 == 0, nums1 has nothing on the left.
             * So pretend left1 is very small.
             *
             * This avoids null checks.
             */

             int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];

            /*
             * If cut1 == m, nums1 has nothing on the right.
             * So pretend right1 is very large.
             *
             * This avoids null checks.
             */
            int right1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];

            /*
             * Same idea for nums2.
             */
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];

            //correct partition condition
            if(left1<=right2 && left2<=right1){
                if (total % 2 == 1) {
                    return Math.max(left1, left2);
                }

                int maxLeft = Math.max(left1, left2);
                int minRight = Math.min(right1, right2);

                return (maxLeft + minRight) / 2.0;
            }else if(left1>right2){
                /*
             * If left1 > right2:
             *
             * Example:
             * nums1: [10, 20] | [30]
             * nums2: [1, 2, 3] | [4, 5, 6]
             *
             * left1 = 20
             * right2 = 4
             *
             * 20 is on the left side,
             * but 4 is on the right side.
             *
             * That is wrong because left side has something too big.
             *
             * The too-big value came from nums1,
             * so we took too many elements from nums1.
             *
             * Move cut1 left.
             */
             right=cut1-1;
            }
            else{
                /*
             * Else left2 > right1:
             *
             * Example:
             * nums1: [1] | [2, 3]
             * nums2: [10, 20] | [30, 40]
             *
             * left2 = 20
             * right1 = 2
             *
             * 20 is on the left side,
             * but 2 is on the right side.
             *
             * That is wrong because nums1 did not contribute enough
             * bigger elements to the left side.
             *
             * So we took too few elements from nums1.
             *
             * Move cut1 right.
             */
             left=cut1+1;
            }
         }
         //we should never reach here if sorted correctly
         return 0.0;
    }
}
