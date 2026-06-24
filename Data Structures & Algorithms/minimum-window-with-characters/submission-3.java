class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> curr=new HashMap<>();
        Map<Character, Integer> req=new HashMap<>();

        if(s.length()<t.length())
        return "";

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            req.put(ch, req.getOrDefault(ch,0)+1);
        }

        int reqCharCount=req.size();

        int left=0;
        int right=0;
        int start=0;
        int minLen=Integer.MAX_VALUE;
        int len=0;
        int formed=0;

        while(right<s.length()){
            char ch=s.charAt(right);
            curr.put(ch,curr.getOrDefault(ch,0)+1);
            if (req.containsKey(ch) && curr.get(ch).intValue() == req.get(ch).intValue()) {
                formed++;
            }

            while(formed==reqCharCount){
                len=right-left+1;
                if(minLen>len){
                    minLen=len;
                    start=left;
                }

                char leftChar = s.charAt(left);
                curr.put(leftChar,curr.getOrDefault(leftChar,0)-1);
                if (req.containsKey(leftChar) && curr.get(leftChar) < req.get(leftChar)) {
                    formed--;
                }
                left++;
            }

            
            right++;
            
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}