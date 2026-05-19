class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
        return "";

        Map<Character, Integer> need=new HashMap<>();
        Map<Character, Integer> window=new HashMap<>();

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            need.put(ch, need.getOrDefault(ch,0)+1);
        }

        int mustHaveCount=need.size();
        int have=0;

        int minLength=Integer.MAX_VALUE;

        int left=0;
        int right=0;

        int minStart=0;

        while(right<s.length()){
            char ch=s.charAt(right);

            window.put(ch, window.getOrDefault(ch,0)+1);

            if(need.containsKey(ch) && need.get(ch).equals(window.get(ch))){
                have++;
            }

            while(have==mustHaveCount){
                int windowLength=right-left+1;

                if(windowLength<minLength){
                    minLength=windowLength;
                    minStart=left;
                }
                
                char leftChar=s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);
                
                if (need.containsKey(leftChar) &&
                    window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    have--;
                }

                left++;
            }
            right++;
        }

        if(minLength==Integer.MAX_VALUE)
        return "";

        return s.substring(minStart, minStart+minLength);
        
    }
}
