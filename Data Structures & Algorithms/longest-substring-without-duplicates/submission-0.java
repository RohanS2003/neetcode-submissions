class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();

        int left=0;
        int maxLength=0;
        int right=0;

        while(right<s.length()){
            char ch=s.charAt(right);

            if(!set.contains(ch)){
                set.add(ch);

                int length=right-left+1;
                maxLength=Math.max(maxLength, length);

                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
