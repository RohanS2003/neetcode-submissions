class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int len=0;
        int left=0;
        int right=0;
        HashSet<Character> set=new HashSet<>();

        while(right<s.length()){
            char ch=s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            len=right-left+1;
            maxLen=Math.max(len, maxLen);
            right++;
        }
        return maxLen;
    }
}
