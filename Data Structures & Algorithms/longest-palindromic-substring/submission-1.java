class Solution {
    public String longestPalindrome(String s) {
        int maxLength=Integer.MIN_VALUE;
        int n=s.length();
        int start=-1;

        for(int i=0;i<n;i++){
            int odd=expandAroundCentre(s,i,i);
            int even=expandAroundCentre(s,i,i+1);

            int currLength=Math.max(odd, even);
            if(currLength>maxLength){
                maxLength=currLength;
                start=i-(currLength-1)/2;
            }
        }

        return s.substring(start,start+maxLength);
    }

    private int expandAroundCentre(String s, int left, int right){
        int n=s.length();
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }
}
