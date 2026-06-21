class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int count = 0;

        for (int i = 0; i < n; i++) {
            count += countPalindromes(s, i, i);
            count += countPalindromes(s, i, i + 1);
        }

        return count;
    }

    private int countPalindromes(String s, int left, int right) {
        int n = s.length();
        int count = 0;

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            count++;

            left--;
            right++;
        }

        return count;
    }
}