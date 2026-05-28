class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(int n, int open, int close,
                           StringBuilder curr,
                           List<String> result){
        if(curr.length()==2*n){
            result.add(curr.toString());
            return;
        }

        if(open<n){
            curr.append('(');
            backtrack(n, open+1, close, curr, result);
            curr.deleteCharAt(curr.length()-1);
        }

        if(close<open){
            curr.append(')');
            backtrack(n, open, close+1, curr, result);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
