class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            end = Math.max(end, lastIndex[ch - 'a']);

            if (i == end) {
                int length = end - start + 1;
                result.add(length);
                start = i + 1;
            }
        }
        return result;
    }
}
