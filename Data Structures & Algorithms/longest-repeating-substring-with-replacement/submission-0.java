class Solution {
    public int characterReplacement(String s, int k) {
        int [] count=new int [26];

        int left=0;
        int right=0;
        int maxLength=0;
        int maxFreq=0;

        while(right<s.length()){
            char ch=s.charAt(right);

            count[ch-'A']++;
            maxFreq=Math.max(maxFreq, count[ch-'A']);

            if((right-left+1)-maxFreq>k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxLength=Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
}
