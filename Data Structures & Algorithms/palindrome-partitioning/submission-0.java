class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(s, 0, curr, result);

        return result;
    }

    private void backtrack(String s, int start,
                           List<String> curr,
                           List<List<String>> result) {
        if(start==s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int end=start;end<s.length();end++){
            if(isPalindrome(s, start, end)){
                curr.add(s.substring(start, end+1));
                backtrack(s,end+1,curr,result);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
