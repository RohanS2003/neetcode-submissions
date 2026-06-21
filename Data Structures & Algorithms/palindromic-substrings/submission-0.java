class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int left, int right){
        if(left>=right)
        return true;

        if(s.charAt(left)!=s.charAt(right))
        return false;

        return isPalindrome(s,left+1, right-1);
    }
}
