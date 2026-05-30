class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int [] freq=new int [26];
            char [] charArray=strs[i].toCharArray();
            for(int j=0;j<charArray.length;j++){
                freq[charArray[j]-'a']++;
            }

            //Arrays.sort(charArray);
            //String sorted=new String(charArray);
            
            String freqString=Arrays.toString(freq);
            map.putIfAbsent(freqString, new ArrayList<>());
            map.get(freqString).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}