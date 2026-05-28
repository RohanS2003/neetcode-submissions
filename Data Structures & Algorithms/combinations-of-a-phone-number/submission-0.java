class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";

        backtrack(digits, 0, new StringBuilder(), result, map);

        return result;
    }

    private void backtrack(String digits, int index,
                           StringBuilder curr,
                           List<String> result,
                           String[] map){
        if(index==digits.length()){
            result.add(curr.toString());
            return;
        }

        char digitChar=digits.charAt(index);
        int digit=digitChar-'0';

        String letters=map[digit];

        for(int i=0;i<letters.length();i++){
            curr.append(letters.charAt(i));

            backtrack(digits, index+1, curr, result, map);

            curr.deleteCharAt(curr.length()-1);
        }
    }
}
